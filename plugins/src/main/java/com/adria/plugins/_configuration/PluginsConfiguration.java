package com.adria.plugins._configuration;

import com.adria.plugins.PluginRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

import static com.adria.plugins._configuration.Constants.PLUGIN_API_ROUTE;

@Component
public class PluginsConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(PluginsConfiguration.class);
    private RequestMappingHandlerMapping requestMappingHandlerMapping;
    private AutowireCapableBeanFactory beanFactory;
    private PluginRegistry pluginRegistry;

    private void registerPlugin(Plugin plugin) throws NoSuchMethodException {
        logger.info("Registering plugin {}", plugin);

        PluginEntry entry = beanFactory.getBean(plugin.getEntry());

        Method[] declaredMethods = plugin.getEntry().getDeclaredMethods();

        for (Method method : declaredMethods) {
            RequestMapping requestMappingAnnotation = method.getAnnotation(RequestMapping.class);
            ResponseBody responseBodyAnnotation = method.getAnnotation(ResponseBody.class);
            if (requestMappingAnnotation == null) {
                logger.info(
                        "Skipping registering Method {} in plugin {} for not having RequestMapping"
                        , method.getName(),
                        plugin.getId()
                );
                continue;
            }
            if (responseBodyAnnotation == null) {
                logger.info(
                        "Skipping registering Method {} in plugin {} for not having ResponseBody annotation"
                        , method.getName(),
                        plugin.getId()
                );
                continue;
            }
            String[] paths = requestMappingAnnotation.path().length > 0 ?
                    requestMappingAnnotation.path() :
                    requestMappingAnnotation.value();
            for (String path : paths) {
                logger.info(
                        "Registering method {} with path url {}, request method {}",
                        method.getName(),
                        path,
                        requestMappingAnnotation.method()
                );
                RequestMappingInfo requestMappingInfo = RequestMappingInfo
                        .paths(
                                String.format(
                                        "%s/%s/%s/%s",
                                        PLUGIN_API_ROUTE,
                                        plugin.getId(),
                                        plugin.getVersion(),
                                        path
                                )
                        )
                        .methods(requestMappingAnnotation.method())
                        .produces(requestMappingAnnotation.produces())
                        .build();
                requestMappingHandlerMapping.
                        registerMapping(requestMappingInfo, entry, method);
            }
        }
    }

    private void registerFrontRenderer() throws NoSuchMethodException {
        Method index = FrontRenderer.class.getMethod("index", Model.class, String.class);
        RequestMapping annotation = index.getAnnotation(RequestMapping.class);
        String path = annotation.path()[0];
        RequestMappingInfo requestMappingInfo = RequestMappingInfo
                .paths(path)
                .methods(annotation.method())
                .produces(annotation.produces())
                .build();
        requestMappingHandlerMapping.
                registerMapping(requestMappingInfo, beanFactory.getBean(FrontRenderer.class), index);
    }

    private void initializePlugins() throws NoSuchMethodException {
        for (Plugin p : this.pluginRegistry.getPluginList()) {
            if (!p.isEnabled()) continue;
            this.registerPlugin(p);
        }
    }

    public void init(
            AutowireCapableBeanFactory beanFactory,
            RequestMappingHandlerMapping requestMappingHandlerMapping,
            PluginRegistry pluginRegistry
    ) {
        this.beanFactory = beanFactory;
        this.requestMappingHandlerMapping = requestMappingHandlerMapping;
        this.pluginRegistry = pluginRegistry;

        try {
            this.initializePlugins();
            this.registerFrontRenderer();
        } catch (NoSuchMethodException e) {
            logger.error("Unable to initiate plugin {}", e.getMessage());
            e.printStackTrace();
        }
    }
}

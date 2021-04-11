package com.adria.core.config;

import com.adria.plugins.Plugin;
import com.adria.plugins.PluginEntry;
import com.adria.plugins.PluginRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author mostafa
 */
@Configuration
public class PluginsConfiguration {
    private static Logger logger = LoggerFactory.getLogger(PluginsConfiguration.class);
    private static final String PLUGIN_WEB_ROUTE = "/plugin";
    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Autowired
    private AutowireCapableBeanFactory beanFactory;

    public void registerPlugin(Plugin plugin) throws NoSuchMethodException {

        logger.info("Registering plugin {}", plugin);

        PluginEntry entry = beanFactory.getBean(plugin.getEntry());

        Method[] declaredMethods = plugin.getEntry().getDeclaredMethods();

        for (Method method : declaredMethods) {
            RequestMapping requestMappingAnnotation = method.getAnnotation(RequestMapping.class);
            if (requestMappingAnnotation == null) {
                logger.info(
                        "Skipping registering Method {} in plugin {} for not having RequestMapping"
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
                                        PLUGIN_WEB_ROUTE,
                                        plugin.getId(),
                                        plugin.getVersion(),
                                        path
                                )
                        )
                        .methods(requestMappingAnnotation.method())
                        .produces(requestMappingAnnotation.produces())
                        .build();
                requestMappingHandlerMapping.
                        registerMapping(requestMappingInfo, entry,
                                plugin.getEntry().getDeclaredMethod(method.getName())
                        );
            }
        }
    }

    @PostConstruct
    public void initializePlugins() throws NoSuchMethodException {
        PluginRegistry pluginRegistry = new PluginRegistry();
        for (Plugin p : pluginRegistry.getPluginList()) {
            if (!p.isEnabled()) continue;
            this.registerPlugin(p);
        }
    }

}

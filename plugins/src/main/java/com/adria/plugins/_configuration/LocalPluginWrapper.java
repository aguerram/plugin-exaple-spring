package com.adria.plugins._configuration;

import com.adria.plugins.PluginRegistry;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.PostConstruct;

@Configuration
public class LocalPluginWrapper {
    private final PluginsConfiguration pluginsConfiguration;
    private final RequestMappingHandlerMapping requestMappingHandlerMapping;
    private final AutowireCapableBeanFactory beanFactory;
    private final PluginRegistry pluginRegistry;

    public LocalPluginWrapper(PluginsConfiguration pluginsConfiguration, RequestMappingHandlerMapping requestMappingHandlerMapping, AutowireCapableBeanFactory beanFactory, PluginRegistry pluginRegistry) {
        this.pluginsConfiguration = pluginsConfiguration;
        this.requestMappingHandlerMapping = requestMappingHandlerMapping;
        this.beanFactory = beanFactory;
        this.pluginRegistry = pluginRegistry;
    }

    @PostConstruct
    public void init() {
        this.pluginsConfiguration.init(
                beanFactory,
                requestMappingHandlerMapping,
                pluginRegistry
        );
    }
}

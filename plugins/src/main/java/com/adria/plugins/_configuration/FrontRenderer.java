package com.adria.plugins._configuration;

import com.adria.plugins.PluginRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import static com.adria.plugins._configuration.Constants.PLUGIN_FRONTEND_ROUTE;

@Component
public class FrontRenderer {

    private final PluginRegistry pluginRegistry;

    public FrontRenderer(PluginRegistry pluginRegistry) {
        this.pluginRegistry = pluginRegistry;
    }

    @RequestMapping(
            path = PLUGIN_FRONTEND_ROUTE + "/{pluginID}/**"
    )
    public String index(Model model, @PathVariable String pluginID) {
        Plugin plugin = this.pluginRegistry.getPlugin(pluginID);
        if (plugin == null) {
            model.addAttribute("pluginID", pluginID);
            return "errors/404";
        }
        model.addAttribute("pluginID", pluginID);
        return "index";
    }
}

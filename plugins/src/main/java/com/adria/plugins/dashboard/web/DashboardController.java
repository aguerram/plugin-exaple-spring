package com.adria.plugins.dashboard.web;

import com.adria.plugins._configuration.PluginEntry;
import com.adria.plugins._configuration.annotations.RegisterPlugin;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RegisterPlugin(id = "dashboard", version = "1.0", name = "Dashboard", enabled = true)
public class DashboardController implements PluginEntry {
    @RequestMapping("/home")
    @ResponseBody
    public String index() {
        return "index";
    }

}

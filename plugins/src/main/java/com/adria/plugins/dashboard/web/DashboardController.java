package com.adria.plugins.dashboard.web;

import com.adria.plugins.Plugin;
import com.adria.plugins.PluginEntry;
import com.adria.plugins.annotations.RegisterPlugin;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RegisterPlugin(id = "dashboard", version = "1.0", name = "Dashboard", entryName = "com.adria.plugins.dashboard.web.DashboardController", enabled = true)
public class DashboardController implements PluginEntry {
    private final String className = this.getClass().getName();
    @RequestMapping("/home")
    public String index() {
        return "index";
    }

}

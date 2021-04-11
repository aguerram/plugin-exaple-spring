package com.adria.plugins.dashboard.web;

import com.adria.plugins.PluginEntry;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class DashboardController implements PluginEntry {
    @RequestMapping("/home")
    public String index() {
        return "index";
    }
}

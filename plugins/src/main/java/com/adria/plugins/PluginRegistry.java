package com.adria.plugins;

import com.adria.plugins.dashboard.web.DashboardController;
import com.adria.plugins.usermanagement.web.UserManagementController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PluginRegistry {
    private final List<Plugin> pluginList;

    public PluginRegistry() {
        pluginList = new ArrayList<>();
        pluginList.addAll(
                Arrays.asList(
                        new Plugin(
                                "dashboard",
                                "1.0",
                                "Dashboard",
                                DashboardController.class,
                                true
                        ),
                        new Plugin(
                                "users",
                                "1.0",
                                "Users Management",
                                UserManagementController.class,
                                true
                        )
                )
        );
    }

    public List<Plugin> getPluginList() {
        return pluginList;
    }
}

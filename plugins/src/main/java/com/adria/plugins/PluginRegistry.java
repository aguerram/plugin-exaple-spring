package com.adria.plugins;

import com.adria.plugins._configuration.Plugin;
import com.adria.plugins.dashboard.web.DashboardController;
import com.adria.plugins.usermanagement.web.UserManagementController;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PluginRegistry {

    private final List<Plugin> pluginList;

    public PluginRegistry() {
        pluginList = new ArrayList<>();
//        Reflections ref = new Reflections("com.adria.plugins", new TypeAnnotationsScanner());
//        for (Class<?> c : ref.getTypesAnnotatedWith(RegisterPlugin.class, true)) {
//            RegisterPlugin registerPluginAnnotation = c.getAnnotation(RegisterPlugin.class);
//            pluginList.add(new Plugin(registerPluginAnnotation.id(), registerPluginAnnotation.version(),
//                    registerPluginAnnotation.name(), (Class<? extends PluginEntry>) c,
//                    registerPluginAnnotation.enabled())
//            );
//        }
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

    public Plugin getPlugin(String id) {
        for (Plugin p : this.pluginList) {
            if (p.getId().equals(id))
                return p;
        }
        return null;
    }

    public List<Plugin> getPluginList() {
        return pluginList;
    }
}

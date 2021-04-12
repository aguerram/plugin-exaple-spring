package com.adria.plugins;

import com.adria.plugins.annotations.RegisterPlugin;
import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;
import java.util.ArrayList;
import java.util.List;

public class PluginRegistry {

    private List<Plugin> pluginList;

    public PluginRegistry() throws ClassNotFoundException {
        pluginList = new ArrayList<>();
        Reflections ref = new Reflections("com.adria.plugins", new TypeAnnotationsScanner());
        for (Class<?> c : ref.getTypesAnnotatedWith(RegisterPlugin.class, true)) {
            RegisterPlugin registerPluginAnnotation = c.getAnnotation(RegisterPlugin.class);
            pluginList.add(new Plugin(registerPluginAnnotation.id(), registerPluginAnnotation.version(),
                    registerPluginAnnotation.name(), (Class<? extends PluginEntry>) c,
                    registerPluginAnnotation.enabled())
            );
        }
//        pluginList.addAll(
//                Arrays.asList(
//                        new Plugin(
//                                "dashboard",
//                                "1.0",
//                                "Dashboard",
//                                DashboardController.class,
//                                true
//                        ),
//                        new Plugin(
//                                "users",
//                                "1.0",
//                                "Users Management",
//                                UserManagementController.class,
//                                true
//                        )
//                )
//        );
    }

    public List<Plugin> getPluginList() {
        return pluginList;
    }
}

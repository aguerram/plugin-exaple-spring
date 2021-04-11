package com.adria.plugins;

public class Plugin {
    private String id;
    private String version;
    private String name;
    private Class<? extends PluginEntry> entry;
    private boolean enabled;


    public Plugin(String id, String version, String name, Class<? extends PluginEntry> entry, boolean enabled) {
        this.id = id;
        this.version = version;
        this.name = name;
        this.entry = entry;
        this.enabled = enabled;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<? extends PluginEntry> getEntry() {
        return entry;
    }

    public void setEntry(Class<? extends PluginEntry> entry) {
        this.entry = entry;
    }

    @Override
    public String toString() {
        return "Plugin{" +
                "id='" + id + '\'' +
                ", version='" + version + '\'' +
                ", name='" + name + '\'' +
                ", entry=" + entry +
                ", enabled=" + enabled +
                '}';
    }
}

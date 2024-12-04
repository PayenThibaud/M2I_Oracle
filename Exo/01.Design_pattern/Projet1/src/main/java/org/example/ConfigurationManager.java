package org.example;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private Map<String, String> config = new HashMap<>();

    private ConfigurationManager(Map<String, String> config) {
        this.config = config;
    }

    public static ConfigurationManager getInstance(Map<String, String> config) {
        if (instance == null) {
            instance = new ConfigurationManager(config);
        }
        return instance;
    }
    public Map<String, String> getConfig() {
        return config;
    }

    public String getValue(String key) {
        return config.getOrDefault(key, "nop");
    }
}

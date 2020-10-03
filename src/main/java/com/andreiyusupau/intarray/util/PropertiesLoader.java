package com.andreiyusupau.intarray.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    private final Properties properties = new Properties();

    public PropertiesLoader() {
        load();
    }

    private void load() {
        try (InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("application.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new PropertyLoadException("Properties file not found");
            }
        } catch (IOException e) {
            throw new PropertyLoadException("Error reading properties file", e);
        }
    }

    public String getProperty(String name) {
        if (properties.containsKey(name)) {
            return properties.getProperty(name);
        } else {
            throw new PropertyLoadException("Property with name \"" + name + "\" does not exists.");
        }
    }
}

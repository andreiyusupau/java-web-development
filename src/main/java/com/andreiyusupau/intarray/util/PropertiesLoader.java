package com.andreiyusupau.intarray.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private final Properties properties = new Properties();

    public PropertiesLoader() {
        load();
    }

    private void load() {
        InputStream inputStream = null;
        try {
            inputStream = this.getClass()
                    .getClassLoader()
                    .getResourceAsStream("application.properties");
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("Properties file not found");
            }
        } catch (IOException e) {
            System.err.println("Error reading properties");
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing stream");
            }
        }
    }

    public String getProperty(String name) {
        if (properties.containsKey(name)) {
            return properties.getProperty(name);
        } else {
            throw new NoSuchPropertyException("Property with name \"" + name + "\" does not exists.");
        }
    }

    private static class NoSuchPropertyException extends RuntimeException {
        public NoSuchPropertyException(String errorMessage) {
            super(errorMessage);
        }
    }
}

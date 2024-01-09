package org.example.utils;

import java.io.IOException;
import java.util.Properties;


public final class PropertiesUtil {
    private static final Properties PROPERTIES = new Properties();
    
    static{
        loadProperties();
    }

    private static void loadProperties() {
        var inputStream = PropertiesUtil.class.getClassLoader()
                .getResourceAsStream("application.properties");

        try {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            System.out.println("failed to upload properties.");;
        }
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }
    /*
    создаем приватный конструктор,
    чтобы нельзя было создать объект утилитного класса.
     */
    private PropertiesUtil() {
    }
}

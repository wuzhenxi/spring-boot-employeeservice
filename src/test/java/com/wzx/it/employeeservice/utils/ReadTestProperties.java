package com.wzx.it.employeeservice.utils;

import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

@Component
public class ReadTestProperties {

    public String getPropertiesForKey(String key) {
        Properties properties = null;
        try {
            properties = PropertiesLoaderUtils.loadAllProperties("ut-data.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}

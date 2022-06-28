package com.icrown.gameapi.commons.utils;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Frank
 */
@Component
public class VersionHelperUtil {
    public String getBuildTime(Object object,String propPath) throws IOException {
        return getProperty(object,"buildTime",propPath);
    }

    public String getBuildVersion(Object object,String propPath) throws IOException {
        return getProperty(object,"buildVersion",propPath);
    }

    public String getBuildProjectName(Object object,String propPath) throws IOException {
        return getProperty(object,"buildProjectName",propPath);
    }

    private String getProperty(Object object, String name,String propPath) throws IOException {
        String path = propPath + "-version.properties" ;
        InputStream stream = object.getClass().getResourceAsStream("/" + path);
        Properties properties = new Properties();
        properties.load(stream);
        String prop = properties.getProperty(name);
        stream.close();
        return prop;
    }
}

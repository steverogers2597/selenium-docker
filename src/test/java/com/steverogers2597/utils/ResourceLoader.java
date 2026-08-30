package com.steverogers2597.utils;

/*
A simple utility to read file.
First we check the classpath. If found, it is used.
If not, then we check the filesystem.
*/

import org.testng.log4testng.Logger;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class ResourceLoader {

    private static final Logger log =  Logger.getLogger(ResourceLoader.class);

    public static InputStream getResource(String path) throws Exception{
        log.info("reading resource from location {}");
        InputStream stream = ResourceLoader.class.getClassLoader().getResourceAsStream(path);
        if(Objects.nonNull(stream)){
            return stream;
        }
        return Files.newInputStream(Path.of(path));
    }

}

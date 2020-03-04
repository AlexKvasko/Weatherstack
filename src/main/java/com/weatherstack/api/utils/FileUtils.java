package com.weatherstack.api.utils;

import org.testng.reporters.Files;

import java.io.File;
import java.io.IOException;

import static java.lang.String.format;

public class FileUtils {

    public static String getJsonData(String folder, String fileName){
        try {
            return Files.readFile(new File(format("src/test/java/resources/data/%s/%s.json", folder, fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

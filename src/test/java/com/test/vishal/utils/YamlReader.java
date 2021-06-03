package com.test.vishal.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;
import org.testng.Reporter;

@SuppressWarnings("unchecked")
public class YamlReader {

    public static String yamlFilePath = "Config.yml";

    public static String getYamlValue(String token) {
        try {
            return getValue(token);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public static String getData(String token) {
        return getYamlValue(token);
    }

    public static Map<String, Object> getYamlValues(String token) {
        Reader doc;
        try {
            doc = new FileReader(yamlFilePath);
        } catch (FileNotFoundException ex) {
            System.out.println("File not valid or missing!!!");
            ex.printStackTrace();
            return null;
        }
        Yaml yaml = new Yaml();
        
        // TODO: check the type casting of object into the Map and create instance in one place
        Map<String, Object> object = (Map<String, Object>) yaml.load(doc);
        return parseMap(object, token + ".");
    }

    private static String getValue(String token) throws FileNotFoundException {
		Reader doc = null;
		try {
			doc = new FileReader(yamlFilePath);
		} catch (FileNotFoundException e) {
			Reporter.log("Wrong tier passed in 'Config.properties' file'", true);
			return null;
		}
        Yaml yaml = new Yaml();
        Map<String, Object> object = (Map<String, Object>) yaml.load(doc);
        return getMapValue(object, token);
    }

    public static String getMapValue(Map<String, Object> object, String token) {
        // TODO: check for proper yaml token string based on presence of '.'
        String[] st = token.split("\\.");
        return parseMap(object, token).get(st[st.length - 1]).toString();
    }

    private static Map<String, Object> parseMap(Map<String, Object> object,
            String token) {
        if (token.contains(".")) {
            String[] st = token.split("\\.");
            object = parseMap((Map<String, Object>) object.get(st[0]),
                    token.replace(st[0] + ".", ""));
        }
        return object;
    }

    public static int generateRandomNumber(int MinRange, int MaxRange) {
        int randomNumber = MinRange
                + (int) (Math.random() * ((MaxRange - MinRange) + 1));
        return randomNumber;
    }
    
}

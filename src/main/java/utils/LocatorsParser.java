package utils;


import org.openqa.selenium.By;

import java.io.IOException;
import java.util.Properties;

public class LocatorsParser {

    public static String uiMappingFile = "/UIMapping.properties";

    public static String getValueFromFile(String key, String fileName) {
        Properties p = new Properties();

        try {
            p.load(LocatorsParser.class.getResourceAsStream(uiMappingFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return (p.getProperty(key));
    }


    public static By ui(String key) throws NoElementFound {
        String[] partsOfLocators = getValueFromFile(key, uiMappingFile).split("\"");
        String findMethod = partsOfLocators[0].substring(0, partsOfLocators[0].length() - 1);
        String target = partsOfLocators[1];


        // Return By class with appropriate method and target
        if (findMethod.equals("xpath")) {
            return By.xpath(target);
        }

        if (findMethod.equals("cssSelector")) {
            return By.cssSelector(target);
        }

        if (findMethod.equals("id")) {
            return By.id(target);
        }

        if (findMethod.equals("class")) {
            return By.name(target);
        }

         throw new NoElementFound("Incorrect type of locator");
    }

}
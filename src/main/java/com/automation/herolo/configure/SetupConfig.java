package com.automation.herolo.configure;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class SetupConfig {

    public  String URL ;
    protected  String userName;
    protected  String browserName;

    public SetupConfig(){
        setup();
    }
    private void setup() {
        Properties prop = new Properties();
        File file = new File("src\\main\\resources\\data.properties");
        try {
            FileInputStream inputDriver = new FileInputStream(file.getAbsolutePath());
            prop.load(inputDriver);
            browserName = prop.getProperty("browser");
            userName = prop.getProperty("userName");
            URL = prop.getProperty("URL");
        } catch (Exception e) {
            System.out.println("Fails to setup configuration file - class ConfigSetup. " + e.getStackTrace());
        }
    }
}

package com.automation.herolo.configure;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager extends SetupConfig {
    public ChromeDriver driver;
    public DriverManager(){
        super();
        initialize();
    }

    private void initialize() {
        try {
            if ("chrome".equals(browserName)) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\" + userName + "\\.m2\\repository\\webdriver\\chromedriver\\win32\\87.0.4280.20\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                driver = new ChromeDriver(options);
            } else if ("firefox".equals(browserName)) {
                System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            }
        }catch (Exception e){
            System.out.println("Fails to initialise browser - class DriverManager"+ e.getStackTrace());
        }
    }
}

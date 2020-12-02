package com.automation.herolo.configure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void login(WebDriver driver, WebElement element){
        driver.get(URL);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
    }
}

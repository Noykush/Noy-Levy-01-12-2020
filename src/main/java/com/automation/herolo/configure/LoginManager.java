package com.automation.herolo.configure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginManager extends SetupConfig{
    public LoginManager(){
        super();
    }
    public void login(WebDriver driver,WebElement element){
        driver.get(URL);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
    }
}

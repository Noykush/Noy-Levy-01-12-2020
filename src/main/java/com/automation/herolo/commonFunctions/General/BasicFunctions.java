package com.automation.herolo.commonFunctions.General;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;

public class BasicFunctions  {
    protected final static org.slf4j.Logger log = LoggerFactory.getLogger(BasicFunctions.class);

    protected  String verifyElementVisibility(WebElement element, WebDriver driver){
        String reportMsg = "";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        log.debug("Start Method verifyElementVisibility");

        try {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            if (element.isDisplayed()) {
                js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid yellow;');", element);
                Thread.sleep(1500);
                log.debug("PASS - Element " + element.getText() + " is Present!\n");
            } else
                reportMsg = "Failure - Element is NOT Present!";
         }catch (Exception e){
             log.error("Exception in 'verifyElementVisibility' Method "+e.getMessage());
             return" Exception in 'verifyElementText' Method - Element Not Found";
         }
        return reportMsg;
    }

    protected  String verifyElementText(WebElement element, String txt, WebDriver driver){
        String reportMsg = "";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        log.debug("Start Method verifyElementText -  Assure Element contains the following text:" +txt);
        try {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            if (element.isDisplayed()) {
                js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
                Thread.sleep(1500);
                if (element.getText().equals(txt))
                    log.debug("PASS - Element " + element.getText() + " is Present!\n");
           } else
                    reportMsg = "Failure - The Text: " + txt + " is NOT Present in the element\n!";
        }catch (Exception e){
            log.error("Exception in 'verifyElementText' Method "+e.getMessage());
            return" Exception in 'verifyElementText' Method - Not Found the text: "+ txt;
        }
        return reportMsg;
    }

    protected  void clickElement(WebElement element, WebDriver driver){
        log.debug("Start Method clickElement");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            if (element.isDisplayed()) {
                js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);            Thread.sleep(2000);
                Thread.sleep(1500);
                element.click();
            } else {
                js.executeScript("arguments[0].scrollIntoView(true);", element);
                if (element.isDisplayed()) {
                    js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
                    Thread.sleep(1500);
                    element.click();
                }
                else
                    System.out.println("Element is NOT Exist, Cannot click on it!");
            }
        }catch (Exception e){
            log.error("Exception in 'clickElement' Method "+e.getMessage());
        }
    }

    protected void checkAndCLosePopup(WebElement popupCloseBtn,WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        log.debug("Start Method closePopup");
        try {
            if (popupCloseBtn.isDisplayed()) {
                log.debug("Popup is Found. Going to perform closing action.");
                try {
                    js.executeScript("arguments[0].scrollIntoView(true);", popupCloseBtn);
                    clickElement(popupCloseBtn, driver);
                }catch (Exception e){
                    log.error("Exception in checkAndCLosePopup - Unable to perform popup clicking"+e.getMessage());
                }
            }
        }catch (Exception e){
            log.debug("No Popup Found "+e.getMessage());
        }
    }
}

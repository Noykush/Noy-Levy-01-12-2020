package com.automation.herolo.commonFunctions.General;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasicFunctions  {

    protected  String verifyElementVisibility(WebElement element, WebDriver driver){
        String reportMsg = "";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if(element.isDisplayed()){
           js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid yellow;');", element);
            System.out.println( "PASS - Element " +element.getText()+" is Present!\n");
        }
        else if(element != null){ // try scroll to element
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            if(element.isDisplayed()){
                js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
                System.out.println( "PASS - Element " +element.getText()+" is Present!\n");
            }
            else
                reportMsg = "Failure - Element is NOT Present!";
        }
        return reportMsg;
    }

    protected  String verifyElementText(WebElement element, String txt, WebDriver driver){
        String reportMsg = "";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println("Assure Element contains the following text: "+txt);
        if(element.isDisplayed()){
            js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
            if(element.getText().equals(txt))
                System.out.println("PASS - Element " +element.getText()+" is Present!\n");
        }
        else
            reportMsg = "Failure - The Text: "+txt+" is NOT Present in the element\n!";
        return reportMsg;
    }
}

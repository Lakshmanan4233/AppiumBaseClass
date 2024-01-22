package com.annotation.locators;

import com.annotation.dropdown.DropDown;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Locators extends DropDown {
    private AndroidDriver<MobileElement> driver;

    Logger log = LogManager.getLogger(Locators.class);

   public Locators(AndroidDriver driver){
       super(driver);
        this.driver = driver;
        log.info("Driver is setted for the Locators Class");
    }


    public WebElement elementByID(By email_id) {
       try {
           WebElement Element = driver.findElement(email_id);
           log.info("Element found  :"+ Element + " and "+" id value:  "+email_id);
           return Element;
       }catch (StaleElementReferenceException | NoSuchElementException e){
           log.error(e);
           log.debug("Element Not found :" +" { Id :" + email_id+" }");
           throw e;
       }
    }

    public  WebElement elementByxpath(By xpath) {

       try {
           WebElement Element = driver.findElement(xpath);
           log.info("Element found  :"+ Element + " and "+" Xpath value:  "+xpath);
           return Element;
       }catch (StaleElementReferenceException | NoSuchElementException e){
           log.error(e);
           log.debug("Element Not found :" +" { xpath :" + xpath+" }");
           throw e;
       }
    }

    public  List<MobileElement> elementsByxpath(By xpath) {

       try {
           List<MobileElement> element = driver.findElements(xpath);
           log.info("Elements found  :"+ element + " and "+" Xpath value:  "+xpath);
           return element;
       }catch (StaleElementReferenceException | NoSuchElementException e){
           log.error(e );
           log.debug("Elements Not found :" +" { xpath :" + xpath+" }");
           throw e;
       }
    }


}

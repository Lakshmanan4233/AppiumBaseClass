package com.annotation.button;

import com.annotation.settings.ObjectRepository;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class Button {

    public AndroidDriver<MobileElement> driver;

    Logger log = LogManager.getLogger(Button.class);

    public Button(AndroidDriver driver){
        this.driver = driver;
        log.info("Driver is setted for the Button Class");
    }

    public void click(By IDORXPATH) {

        WebElement WEBELEMENT = null;

        try{
            WEBELEMENT = driver.findElement(IDORXPATH);
            log.info("Element Found !!!" + IDORXPATH);
        }catch (NoSuchElementException | StaleElementReferenceException e){
            log.error(e + "Element not found " + IDORXPATH);
            throw e;
        }

        try{
            if(WEBELEMENT != null)
                WEBELEMENT.click();
            log.info("Action : Click " + WEBELEMENT);

        }catch (NullPointerException e){
            log.error(e + "Webelement is "+ WEBELEMENT );
            throw  e;
        }

    }

}

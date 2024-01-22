package com.annotation.textfield;

import com.annotation.settings.ObjectRepository;
import com.annotation.tap.Tap;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

public class TextField extends Tap {

    private  AndroidDriver<MobileElement> driver;
    Logger log = LogManager.getLogger(TextField.class);

    public TextField(AndroidDriver<MobileElement> driver){
            super(driver);
            this.driver = driver;
            log.info("Driver is setted for the TextField  Class");
    }

    public void sendWithkeyboard(String keyToSend) {

        try{
            driver.getKeyboard().sendKeys(keyToSend);
            log.info("Value passed :  "+ keyToSend);
        }catch (Exception e){
            log.error(e);
            throw e;
        }
    }

    public void sendwithoutkeyboard(By IDORXPATH, String keyToSend) {

            WebElement WEBELEMENT = null;

            try{
                WEBELEMENT = driver.findElement(IDORXPATH);
                log.info("Element Found !!!" + IDORXPATH);
            }catch (NoSuchElementException | StaleElementReferenceException  e){
                log.error(e + "Element not found " + IDORXPATH);
                throw e;
            }

            try{
                if(WEBELEMENT != null)
                    WEBELEMENT.sendKeys(keyToSend);
                log.info("Value passed  for element of "+ WEBELEMENT +" , value:  "+ keyToSend);

            }catch (NullPointerException e){
                    log.error(e + "Webelement is "+ WEBELEMENT );
                    throw  e;
            }

    }

    public void clearFieldvalue(By IDORXPATH) {


        WebElement WEBELEMENT = null;

        try{
            WEBELEMENT = driver.findElement(IDORXPATH);
            log.info("Element Found !!!" + IDORXPATH);
        }catch (NoSuchElementException | StaleElementReferenceException  e){
            log.error(e + "Element not found " + IDORXPATH);
            throw e;
        }

        try{
            if(WEBELEMENT != null)
                WEBELEMENT.clear();
            log.info("Field value cleared element of "+ WEBELEMENT);

        }catch (NullPointerException e){
            log.error(e +" Element : "+ WEBELEMENT);
            throw e;
        }

    }



}

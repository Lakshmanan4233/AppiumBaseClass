package com.annotation.navigation;

import com.annotation.locators.Locators;
import com.annotation.settings.ObjectRepository;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Navigation extends Locators {

    private AndroidDriver<MobileElement> driver;

    Logger log = LogManager.getLogger(Navigation.class);

    public Navigation(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        log.info("Driver is setted for the Navigation Class");
    }

    public  void back() {

        try{
            driver.navigate().back();
            log.info("");
        }catch (NullPointerException e){
            log.error(e);
            throw e;
        }


    }


    public  void quit() {
    try{
        driver.quit();
        log.info("");
    }catch (NullPointerException e){
        log.error(e);
        throw e;
    }
    }

    public void hideKeyboard() {
    try{
        driver.hideKeyboard();
        log.info("");
    }catch (NullPointerException e){
        log.error(e);
        throw e;
    }
    }

}

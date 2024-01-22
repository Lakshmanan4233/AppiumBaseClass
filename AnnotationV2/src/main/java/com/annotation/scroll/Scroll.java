package com.annotation.scroll;

import com.annotation.exception.NoOptionFoundException;
import com.annotation.reusable.Reuse;
import com.annotation.settings.ObjectRepository;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

public class Scroll extends Reuse {

    private AndroidDriver<MobileElement> driver;

    Logger log = LogManager.getLogger(Scroll.class);

    public Scroll(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        log.info("Driver is setted for the Scroll Class");
    }


    public boolean scroll_TxtContains(String optionToSelect) {

        try {
            return driver.findElementByAndroidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
                                    + optionToSelect + "\").instance(0))")
                    .isDisplayed();
        }catch (Exception e){
            log.error(e +"  Value not displayed on the given context "+ "   Value : "+ optionToSelect);
            throw e;
        }
    }


    public boolean  scroll_TxtMatch(String optionToSelect) {

        try {
            return driver.findElementByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\""
                            + optionToSelect + "\").instance(0))").isDisplayed();
        }catch (Exception e){
            log.error(e +"  Value not displayed on the given context "+ "   Value : "+ optionToSelect);
            throw e;
        }

    }


    public  void scroll_TextMatch(String optionToSelect) {
        try {
            driver.findElementByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\""
                            + optionToSelect + "\").instance(0))");
        }catch (Exception e){
                log.error(e +"  Value not matched with the given context "+ "   Value : "+ optionToSelect);
                throw e;
        }

    }

    public  void scroll_TextContains(String optionToSelect) {
        try {
            driver.findElementByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
                            + optionToSelect + "\").instance(0))");
        }catch (Exception e){
            log.error(e +"  Value not matched with the given context "+ "   Value : "+ optionToSelect);
            throw e;
        }

    }
}

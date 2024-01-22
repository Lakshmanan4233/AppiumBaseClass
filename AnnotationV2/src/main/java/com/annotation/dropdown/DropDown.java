package com.annotation.dropdown;

import com.annotation.button.Button;
import com.annotation.settings.ObjectRepository;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DropDown extends Button {

    private AndroidDriver<MobileElement> driver;

    Logger log = LogManager.getLogger(DropDown.class);

    public DropDown(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        log.info("Driver is setted for the Dropdown Class");
    }


    // ScrollDown and select the option on the drodpown with Text Contains
    public  void selectOpt_TextContians_Scroll(String optionToSelect) {
        try {
            driver.findElementByAndroidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
                                    + optionToSelect + "\").instance(0))")
                    .click();
            log.info("Options Selected : " + optionToSelect);
        }catch (Exception e){
            log.error(e +"  Option not displayed in the given context "+ "   Value : "+ optionToSelect);
            throw e;
        }

    }

    // ScrollDown and select the option on the drodpown with Start With
    public  void selectOpt_TextStartWith_Scroll(String optionToSelect) {
       try {
           driver.findElementByAndroidUIAutomator(
                           "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textStartsWith(\""
                                   + optionToSelect + "\").instance(0))")
                   .click();
           log.info("Options Selected : " + optionToSelect);
       }catch (Exception e){
           log.error(e +"  Option not displayed in the given context "+ "   Value : "+ optionToSelect);
           throw e;
       }

    }

    // ScrollDown and select the option on the drodpown with End With
    public  void selectOpt_TextEndWith_Scroll(String optionToSelect) {
       try {
           driver.findElementByAndroidUIAutomator(
                           "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textEndsWith(\""
                                   + optionToSelect + "\").instance(0))")
                   .click();
           log.info("Options Selected : " + optionToSelect);
       }catch (Exception e){
           log.error(e +"  Option not displayed in the given context "+ "   Value : "+ optionToSelect);
           throw e;
       }

    }

    // ScrollDown and select the option on the drodpown with End With
    public  void selectOpt_ExactText_Scroll(String optionToSelect) {
        try {
            driver.findElement(MobileBy.AndroidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
                                    + optionToSelect + "\").instance(0))"))
                    .click();
            log.info("Options Selected : " + optionToSelect);
        }catch (Exception e){
            log.error(e +"  Option not displayed in the given context "+ "   Value : "+ optionToSelect);
            throw e;
        }
    }

    // ScrollDown and Get Text with Text Matches
    public  String getText_TextMatch_Scroll(String optionToSelect) {

        try {
            return driver.findElementByAndroidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\""
                                    + optionToSelect + "\").instance(0))")
                    .getText();

        }catch (Exception e){
            log.error(e +"  Text is not found in the given context");
            throw e;
        }

    }

    // ScrollDown and Get Text with Text Contains
    public  String getText_TextContians_Scroll(String optionToSelect) {

        try {
            return driver.findElementByAndroidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
                                    + optionToSelect + "\").instance(0))")
                    .getText();
        }catch (Exception e){
            log.error(e +"  Text is not found in the given context");
            throw e;
        }
    }
}

package com.annotation.wait;

import com.annotation.navigation.Navigation;
import com.annotation.settings.ObjectRepository;
import com.annotation.textfield.TextField;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Wait extends TextField {

    private AndroidDriver<MobileElement> driver;
    Logger log = LogManager.getLogger(Wait.class);

    public Wait(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        log.info("Driver is setted for the Wait Class");
    }

    // Implicity wait seconds
    public  void implicitywaits(int sec) {
        try{
            driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
            log.info("Implicitly wait "+ sec);
        }catch (NullPointerException e){
            log.error(e +"Driver is null!!!" + driver);
            throw e;
        }


    }

    // Implicity wait seconds
    public  void pageloadtimeout(int sec) {
        try {
            driver.manage().timeouts().pageLoadTimeout(sec, TimeUnit.SECONDS);
            log.info("Implicitly wait "+ sec);
        }catch (NullPointerException e){
            log.error(e + " Driver is null!!!! "+ driver);
            throw e;
        }
    }

    // Validate the elements
    public  WebElement getElementwithWait(long seconds , Function function) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, seconds);
            WebElement element = (WebElement) wait.until(function);
            return element;
        }catch (Exception e){
            log.error(e);
            throw e;
        }

    }

    public  boolean elementIsPresent(long seconds , Function function) {

        try{
            WebDriverWait wait = new WebDriverWait(driver, seconds);
            WebElement element = (WebElement) wait.until(function);
            return element.isDisplayed();
        }catch (Exception e){
            log.error(e);
            throw e;
        }
    }

}

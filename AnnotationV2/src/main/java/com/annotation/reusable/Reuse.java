package com.annotation.reusable;

import com.annotation.navigation.Navigation;
import com.annotation.settings.ObjectRepository;
import com.annotation.wait.Wait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class Reuse extends Navigation {

    private AndroidDriver<MobileElement> driver;

    Logger log = LogManager.getLogger(Reuse.class);

    public Reuse(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        log.info("Driver is setted for the Reuse Class");
    }

    public  boolean isdisplayedWithTryCatch(By IDORXPATH){

        try {

            driver.findElement(IDORXPATH);
            log.info("Element Found !!");
            return true;
        }catch(NoSuchElementException e) {
            log.warn(e);
        }

        return false;
    }

    public boolean isDisplayed(By IDORXPATH) {
        try {
            return driver.findElement(IDORXPATH).isDisplayed();
        }catch (NoSuchElementException e){
            log.error(e + "Element Not found !!!!  " + IDORXPATH);
            throw e;
        }

    }

    public  ArrayList<Integer> getWindowSize(){

        try {
            ArrayList<Integer> win_Size = new ArrayList<Integer>();

            int height = driver.manage().window().getSize().getHeight();
            int width = driver.manage().window().getSize().getWidth();

            win_Size.add(width);
            win_Size.add(height);

            log.info(win_Size);

            return win_Size;
        }catch (NullPointerException e){
            log.error(e);
            throw e;
    }
    }

    public  ArrayList<Integer> get_XYThe_Coordinate(WebElement element) {

        try {
            int x_Coordinate = element.getLocation().getX();
            int y_Coordinate = element.getLocation().getY();

            ArrayList<Integer> coordinate = new ArrayList();
            coordinate.add(x_Coordinate);
            coordinate.add(y_Coordinate);
            log.info(coordinate);

            return coordinate;
        }catch (NoSuchElementException e){
            log.error(e);
            throw e;
        }
    }

    public  String get_Text(WebElement element) {
        try {
            String text = element.getText();
            log.info(text);
            return text;
        }catch (NoSuchElementException e){
            log.error(e);
            throw e;
        }
    }


    //Get Text
    public  String get_Attribute(WebElement element , String attri_name) {
        try {
            String text = element.getAttribute(attri_name);
            log.info("Attribute value for "+attri_name+"  "+ text);
            return text;
        }catch (Exception e){
            log.error(e);
            throw e;
        }
    }


    public void pushFile(String remotenewfileLocation , String localfileLocation){

        driver.pushFile(remotenewfileLocation , localfileLocation.getBytes());
    }
}

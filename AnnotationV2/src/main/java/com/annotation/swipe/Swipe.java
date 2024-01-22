package com.annotation.swipe;

import com.annotation.scroll.Scroll;
import com.annotation.settings.ObjectRepository;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class Swipe extends Scroll {

    private AndroidDriver<MobileElement> driver;

    Logger log = LogManager.getLogger(Swipe.class);

    public Swipe(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        log.info("Driver is setted for the Swipe  Class");
    }


    public void swipe(int pressX, int pressY, int moveX, int moveY) {

        try {
            TouchAction action = new TouchAction(driver);
            action.press(PointOption.point(pressX, pressY)).
                    moveTo(PointOption.point(moveX, moveY)).
                    release().perform();
            log.info("Swipe action perfomed!!" + "  "+
                    "Start X , Y : "+ pressX +" ,"+ pressY+'\n'+
                    "End X , Y : "+ moveX + " , "+ moveY);
        }catch (Exception e){
            log.error(e);
            throw e;
        }

    }

    public void swipeWithWait(int pressX, int pressY, int moveX, int moveY, long duration) {

        try {
            TouchAction action = new TouchAction(driver);
            action.press(PointOption.point(pressX, pressY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(duration)))
                    .moveTo(PointOption.point(moveX, moveY)).
                    release().perform();
            log.info("Swipe action perfomed!!" + "  "+
                    "Start X , Y : "+ pressX +" ,"+ pressY+'\n'+
                    "End X , Y : "+ moveX + " , "+ moveY +'\n'+
                    " Duration : "+ duration);
        }catch (Exception e){
            log.error(e);
            throw e;
        }

    }

}

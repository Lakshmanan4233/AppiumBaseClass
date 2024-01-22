package com.annotation.tap;

import com.annotation.settings.ObjectRepository;
import com.annotation.swipe.Swipe;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class Tap extends Swipe {
    private AndroidDriver<MobileElement> driver;

    Logger log = LogManager.getLogger(Tap.class);

    public Tap(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        log.info("Driver is setted for the Tap Class");
    }


    public  void tap(int x, int y) {

        try {
            TouchAction action = new TouchAction(driver);
            action.tap(PointOption.point(x, y)).
                    perform();
            log.info("Tap action performed : "+ " X , Y "+ x +" , "+y);
        }catch (Exception e){
            log.error(e);
            throw e;
        }
    }

    public  void tapWithWait(int x, int y, long duration) {

        try {
            TouchAction action = new TouchAction(driver);
            action.tap(PointOption.point(x, y)).
                    waitAction(WaitOptions.waitOptions(Duration.ofSeconds(duration))).
                    perform();
            log.info("Tap action performed : "+ " X , Y "+ x +" , "+y + "  with duration of "+ duration
            + "  seconds");
        }catch (Exception e){
            log.error(e);
            throw e;
        }
    }
}

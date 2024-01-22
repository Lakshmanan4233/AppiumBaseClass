package com.annotation.initializedriver;

import com.annotation.exception.NosuitableDriverFoundException;
import com.annotation.settings.ObjectRepository;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SetDriver {
    Dotenv dotEnv = Dotenv.configure().directory("./src/main/resources/Config").filename("AnnotationV2.env").load();

    Logger log = LogManager.getLogger(SetDriver.class);
    public AndroidDriver<MobileElement> init_driver(String automationMode, String app_Installed, String location_App, String realDevName, String realDevUDID) throws MalformedURLException {

        log.info("Getting data from Dot env file  "+'\n'+
                "{Automation Mode:  "+automationMode +"} ,"+
                "{App Installed Status:  "+ app_Installed + " },"+
                "{App Location:  "+location_App+" }, "+
                "{ RealDevice Name:  "+realDevName+" },"+
                "{ RealDevice UDID:  "+realDevUDID );

        log.info("Checking the automation mode  {Automation Mode}:"+automationMode);

        try {
            switch (automationMode) {
                case "WithEmulator":

                    log.info("Driver initilization for Android device using  " + automationMode);

                    switch (app_Installed) {
                        case "true":

                            log.info("Driver initilization started for" + automationMode + "  " + app_Installed);

                            DesiredCapabilities APP_TRUE_CAP = new DesiredCapabilities();

                            APP_TRUE_CAP.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
                            APP_TRUE_CAP.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                            APP_TRUE_CAP.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

                            URL APP_TRUE_URL = new URL("http://0.0.0.0:4723");

                            return new AndroidDriver<MobileElement>(APP_TRUE_URL, APP_TRUE_CAP);

                        case "false":

                            log.info("Driver initilization started for" + automationMode + "  " + app_Installed);

                            DesiredCapabilities APP_FALSE_CAP = new DesiredCapabilities();

                            APP_FALSE_CAP.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
                            APP_FALSE_CAP.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                            APP_FALSE_CAP.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                            APP_FALSE_CAP.setCapability(MobileCapabilityType.APP, location_App);

                            URL APP_FALSE_URL = new URL("http://0.0.0.0:4723");

                            return new AndroidDriver<MobileElement>(APP_FALSE_URL, APP_FALSE_CAP);
                    }
                case "WithRealDevice":

                    log.info("Driver initilization for Android device using  " + automationMode);

                    DesiredCapabilities REALDEVICE_CAP = new DesiredCapabilities();

                    REALDEVICE_CAP.setCapability(MobileCapabilityType.DEVICE_NAME, realDevName);
                    REALDEVICE_CAP.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                    REALDEVICE_CAP.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                    REALDEVICE_CAP.setCapability(MobileCapabilityType.UDID, realDevUDID);
                    REALDEVICE_CAP.setCapability("newCommandTimeout", 100);
                    REALDEVICE_CAP.setCapability("appium:ignoreHiddenApiPolicyError", true);

                    URL REALDEVICE_URL = new URL("http://0.0.0.0:4723");

                    return new AndroidDriver<MobileElement>(REALDEVICE_URL, REALDEVICE_CAP);

                default:
                    throw new NosuitableDriverFoundException("Driver not initiated!! Check your Dot Env file");
            }
        }catch (Exception e){
            log.error(e.getMessage());
            throw e;
        }

    }

   public void setupDriver(Scenario sceanrio) throws MalformedURLException {
        log.info("Setting the driver for the {Scenario:  "+ sceanrio.getName() + "  }");
       ObjectRepository.driver = init_driver(dotEnv.get("Automation_Mode"),
               dotEnv.get("App_Installed"),dotEnv.get("App_Location"),
               dotEnv.get("RealDeviceName"),dotEnv.get("RealDeviceUDID"));
       log.info("Driver initialited!!" +"{Automation Mode: }" +dotEnv.get("Automation_Mode") +'\n'+
               "{App Installed Status: }"+dotEnv.get("App_Installed")+'\n'+
                       "{App Location: }"+ dotEnv.get("App_Location")+'\n'+
                       "{Real Device Name: }"+ dotEnv.get("RealDeviceName")+'\n'+
                       "{Real Device UDID: }"+ dotEnv.get("RealDeviceUDID"));
       ObjectRepository.driver.manage()
               .timeouts()
               .implicitlyWait(Integer.parseInt(dotEnv.get("Implicity_Wait")),TimeUnit.SECONDS);

    }


    public void tearDown(Scenario sceanrio){

        try {
            if (ObjectRepository.driver != null) {
                if (sceanrio.isFailed()) {
                    log.info(sceanrio.getName() + "   Failed!!! Check the screen shot");
                    TakesScreenshot screenshot = (TakesScreenshot) ObjectRepository.driver;
                    byte[] failure = screenshot.getScreenshotAs(OutputType.BYTES);
                    sceanrio.attach(failure, "image/png", "Failure.png");

                    ObjectRepository.driver = null;
                    log.info("Shutting Down the driver!!!");
                    log.info("Driver exited!!!!!");
                }

                ObjectRepository.driver = null;
                log.info("Shutting Down the driver!!!");
                log.info("Driver exited!!!!!");

            } else {
                log.error("Driver is null. Please check driver setup!!!");
            }
        }catch (Exception e){
            log.error(e);
            throw e;
        }

    }


    @Before
    public void beforeScenario(Scenario sceanrio) throws MalformedURLException {
        setupDriver(sceanrio);
        log.info("Driver Initiated Successfull!!!!!");
    }


    @After
    public void afterSceanrio(Scenario sceanrio){
        tearDown(sceanrio);
        log.info("" + '\n');
    }
}

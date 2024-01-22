package com.annotation.settings;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ObjectRepository {

    public static AndroidDriver<MobileElement> driver;
    public static Map<String, Object> data = new LinkedHashMap<String , Object>();

}

package com.smartlk;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriver {
    public static org.openqa.selenium.WebDriver driver;

    public static void setDriver(){
//        System.out.println("driver running");
        System.setProperty("webdriver.chrome.driver","web_driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    public static void closeDriver(){
        driver.quit();
    }

}

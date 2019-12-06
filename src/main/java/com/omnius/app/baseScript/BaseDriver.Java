package com.omnius.app.baseScript;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseDriver {
    protected static WebDriver driver;

    @BeforeTest
    public void createTestEnvironment() {
        CompositeConfiguration config = new CompositeConfiguration();
        try {
            config.addConfiguration(new PropertiesConfiguration("src/main/resources/config.properties"));
        } catch (org.apache.commons.configuration.ConfigurationException e) {
            e.printStackTrace();
        }
        System.setProperty("webdriver.chrome.driver", config.getProperty("WEB_DRIVER_PATH").toString());
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
        driver.get(config.getProperty("BASE_URL").toString());
    }

    @AfterTest
    public void exitTestEnvironment() {
        driver.quit();
    }

}

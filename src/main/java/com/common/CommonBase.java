package com.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.constants.*;


public class CommonBase
{
    public static WebDriver driver;
    public static Properties property;
    public static ChromeOptions chromeOptions;
    public static EventFiringWebDriver e_driver;

    public CommonBase()
    {
        try
        {
            property = new Properties();
            FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "src/main/resources/config/qa/application.properties");
            property.load(inputStream);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void initialization()
    {

        String browserName = System.getProperty("Browser");
        if(browserName.equals("Chrome"))
        {
            chromeOptions = new ChromeOptions();
            System.setProperty("webdriver.chrome.driver", CommonConstants.CHROME_DRIVER_PATH);
            driver = new ChromeDriver(chromeOptions);
        }
        else if(browserName.equals("IE"))
        {
            System.setProperty("webdriver.ie.driver", CommonConstants.INTERNET_EXPLORER_DRIVER_PATH);
            driver = new InternetExplorerDriver();
        }
        else if(browserName.equals("Firefox"))
        {
            System.setProperty("webdriver.gecko.driver", CommonConstants.FIREFOX_DRIVER_PATH);
            driver = new FirefoxDriver();
        }
        else
        {
            System.out.println("Path of Driver Executable is not Set for any Browser");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(CommonConstants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(CommonConstants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(property.getProperty("Url"));
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown() throws IOException
    {
        driver.quit();
    }
}
package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.common.CommonBase;
import org.apache.commons.io.FileUtils;
//import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.constants.CommonConstants;


public class TestUtil extends CommonBase
{
    public static Workbook book;
    public static Sheet sheet;
    public static Actions actions;
    public static Select select;
    public static Alert alert;

    public static void openUrl(String pageURL){
       driver.manage().window().maximize();
       driver.navigate().to(pageURL);

    }


    //To Take Screenshot at End Of Test.
    public static void takeScreenshotAtEndOfTest() throws IOException
    {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/" + System.currentTimeMillis() + ".png"));
    }

    //Explicit Wait to Click on WebElement.
    public static void clickOn(WebDriver driver, WebElement element, int timeout)
    {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    //Explicit Wait to Send Data to WebElement.
    public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value)
    {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }

    //Wait until element is visible
    public static void waitForElementToBeVisible(WebDriver driver, By locator, int timeout)
    {
        new WebDriverWait(driver, timeout).
                until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //Handle multiple windows
    public void switchWindow(WebDriver driver, String firstWindow, String secondWindow)
    {
        Set<String> windowHandles = driver.getWindowHandles();
        for(String windows : windowHandles)
        {
            if(!windows.equals(firstWindow) && !windows.equals(secondWindow))
            {
                driver.switchTo().window(windows);
            }
        }
    }

    //Check if element is present or not
    public static void isElementPresent(WebElement element)
    {
        boolean elementDisplayed = element.isDisplayed();
        if(elementDisplayed)
        {
            System.out.println("Element is pRESENT");
        }
        else
        {
            System.out.println("Element is not present");
        }
    }

    //To check if element is enabled or not
    public static void isElementEnabled(WebElement element)
    {
        boolean elementEnabled = element.isEnabled();
        if(elementEnabled)
        {
            System.out.println("Element is Enabled");
        }
        else
        {
            System.out.println("Element is not Enabled");
        }
    }




    //To Print all Values and Select a Required Value from Drop Down.
    public static void selectDropDownValue(String xpathValue, String value)
    {
        List<WebElement> monthList = driver.findElements(By.xpath(xpathValue));
        System.out.println(monthList.size());

        for(int i=0; i<monthList.size(); i++)
        {
            System.out.println(monthList.get(i).getText());
            if(monthList.get(i).getText().equals(value))
            {
                monthList.get(i).click();
                break;
            }
        }
    }

    //To Validate Drop Down Values.
    public static List<String> dropDownValuesValidation(WebElement element)
    {
        Select select = new Select(element);
        List<WebElement> dropDownValues = select.getOptions();

        List<String> toolsDropDownValues = new ArrayList<String>();

        for(WebElement listOfDropDownValues : dropDownValues)
        {
            toolsDropDownValues.add(listOfDropDownValues.getText());
        }
        return toolsDropDownValues;
    }

    //To Select Radio Button.
    public void selectRadioButton(List<WebElement> element, String value)
    {
        for(WebElement elements : element)
        {
            if(elements.getText().equalsIgnoreCase(value))
            {
                elements.click();
                break;
            }
        }
    }



    //To Match Value with List of Elements and Click on it.
    public void clickOnMatchingValue(List<WebElement> listOfElements, String valueToBeMatched)
    {
        for(WebElement element : listOfElements)
        {
            if(element.getText().equalsIgnoreCase(valueToBeMatched))
            {
                element.click();
                return;
            }
        }
    }

    //To Click on Element using Actions Class.
    public void clickOnElementUsingActions(WebElement element)
    {
        actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    //To Mouse Hover and Click or Select an Element using Actions Class.
    public static void moveToElement(WebDriver driver, WebElement element)
    {
        actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    //To perform Double Click action using Actions Class.
    public static void doubleClick(WebDriver driver, WebElement element)
    {
        actions = new Actions(driver);
        actions.doubleClick(element).build().perform();
    }





}

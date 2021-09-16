package com.pages;

import com.common.CommonBase;
import com.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends CommonBase
{

    private String signinLink="//a[normalize-space()='Sign in']";
    private String signoutLink="//a[normalize-space()='Sign up']";
    private String channels="//span[@title='channels']";
    private String djangoprojectLink="//span[@title='djangoproject.com']";
    private String packgesTab="//a[@class='UnderlineNav-item '][normalize-space()='Packages']";
    private static String url="https://github.com/django";

    @FindBy(xpath = "//a[@class='UnderlineNav-item selected']']")
    static
    WebElement repositoriesTab;

    @FindBy(xpath= "//a[@class='UnderlineNav-item selected']")
    static
    WebElement overviewTab;

    public HomePage()
    {
        PageFactory.initElements(driver, this);
    }

    public static void openHomePage(){
        TestUtil.openUrl(url);
        verifyHomePageTitle();
    }

    public static String verifyHomePageTitle()
    {
        return driver.getTitle();
    }

    public void clickOnOverview()
    {
        Actions action = new Actions(driver);
        action.moveToElement(overviewTab).build().perform();
        overviewTab.click();
    }

    public static void clickOnRepositories()
    {
        Actions action = new Actions(driver);
        action.moveToElement(repositoriesTab).build().perform();
        repositoriesTab.click();
    }


}
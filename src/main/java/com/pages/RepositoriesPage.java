package com.pages;

import com.common.CommonBase;
import com.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RepositoriesPage extends CommonBase{

public static void checkrepositories() {
    List<WebElement> allLinks = driver.findElements(By.tagName("a"));
    for(WebElement link:allLinks){
        System.out.println(link.getText() + " - " + link.getAttribute("href"));
    }


}

}

package com.internetqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropdownListPage extends BasePage{
    public DropdownListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "dropdown")
    WebElement dropdown;

    public DropdownListPage selectOption(String visibleText) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
        return this;
    }

    public DropdownListPage verifySelectedOption(String expectedText) {
        Select select = new Select(dropdown);
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actual, expectedText);
        return this;
    }
}



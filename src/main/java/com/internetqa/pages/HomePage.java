package com.internetqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='/login']")
    WebElement form;

    public LoginPage goToLoginPage() {
        click(form);
        return new LoginPage(driver);
    }
}


package com.internetqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    WebElement user;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(css = ".fa.fa-2x.fa-sign-in")
    WebElement loginButton;

    public LoginPage enterUserData(String userName, String password) {
        type(user, userName);
        type(passwordField, password);
        return this;
    }

    public SecureAreaPage clickOnLoginButton() {
        click(loginButton);
        return new SecureAreaPage(driver);
    }
}

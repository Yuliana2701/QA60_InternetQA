package com.internetqa.tests;

import com.internetqa.pages.HomePage;
import com.internetqa.pages.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {
        SecureAreaPage secureAreaPage = new HomePage(driver)
                .goToLoginPage()
                .enterUserData("tomsmith", "SuperSecretPassword!")
                .clickOnLoginButton();

        String message = secureAreaPage.getSuccessMessage();
        Assert.assertTrue(message.contains("You logged into a secure area!"), "Success message is incorrect");
    }
}


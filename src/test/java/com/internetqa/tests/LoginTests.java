package com.internetqa.tests;

import com.internetqa.pages.HomePage;
import com.internetqa.pages.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Parameters({"userName", "password"})
    @Test
    public void loginPositiveTest(String userName,String password) {
        SecureAreaPage secureAreaPage = new HomePage(driver)
                .goToLoginPage()
                .enterUserData(userName,password)
                .clickOnLoginButton();

        String message = secureAreaPage.getSuccessMessage();
        Assert.assertTrue(message.contains("You logged into a secure area!"), "Success message is incorrect");
    }
}


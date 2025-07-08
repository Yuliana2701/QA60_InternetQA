package com.internetqa.tests;

import com.internetqa.pages.HomePage;
import com.internetqa.pages.alertsFrameWindows.AlertsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {

    @BeforeMethod
    public void precondition() {
 //       new HomePage(driver).selectFrame();
        new HomePage(driver).selectAlerts();

    }

    @Test
    public void alertTest() {
         new AlertsPage(driver).selectResult("Ok")
                .verifyToResult("You successfully clicked an alert");
    }


    @Test
    public void alertWithSelectTest() {
        new AlertsPage(driver).selectToResult("Cancel").verifyResult("Cancel");
    }

    @Test
    public void sendMessageToAlert() {
        new AlertsPage(driver).sendMessageToAlert("Hello Yuliana!").verifyMessage("Hello Yuliana!");
    }
}


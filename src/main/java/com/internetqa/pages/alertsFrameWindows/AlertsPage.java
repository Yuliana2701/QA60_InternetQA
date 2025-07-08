package com.internetqa.pages.alertsFrameWindows;

import com.internetqa.pages.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[normalize-space()='Click for JS Alert']")
    WebElement jsAlertButton;

    public AlertsPage selectResult(String result) {
        clickWithJS(jsAlertButton, 0 ,300);
        if (result != null) {
            driver.switchTo().alert().accept();

        }
            return this;

    }
    @FindBy(id = "result")
    WebElement jsAlertResult;
    public AlertsPage verifyToResult(String text) {
        assertTrue(jsAlertResult.getText().contains(text));
        return this;
    }

    @FindBy(xpath = "//button[normalize-space()='Click for JS Confirm']")
    WebElement jsConfirmButton;
    public AlertsPage selectToResult(String result) {
        clickWithJS(jsConfirmButton, 0 ,300);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        if (result != null) {
            if (result.equalsIgnoreCase("OK")) {
                alert.accept();
            } else if (result.equalsIgnoreCase("Cancel")) {
                alert.dismiss();
            }
        }
        wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));

        return this;
    }

    @FindBy(id = "result")
    WebElement jsConfirmResult;
    public AlertsPage verifyResult(String text) {
        Assert.assertTrue(jsConfirmResult.getText().contains(text));
        return this;
    }


    @FindBy(css = "button[onclick='jsPrompt()']")
    WebElement jsPromtButton;
    public AlertsPage sendMessageToAlert(String message) {
        clickWithJS(jsPromtButton, 0, 300);
        if (message != null){
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }
        return this;
    }
    @FindBy(id = "result")
    WebElement promtResult;
    public AlertsPage verifyMessage(String text) {
        assertTrue(promtResult.getText().contains(text));
        return this;
    }
}

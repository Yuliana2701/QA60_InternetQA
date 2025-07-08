package com.internetqa.pages;

import com.internetqa.pages.alertsFrameWindows.AlertsPage;
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
    @FindBy(css = "a[href='/javascript_alerts']")
    WebElement alerts;
    public AlertsPage selectAlerts(){
        click(alerts);
        return new AlertsPage(driver);
    }

//    @FindBy(css = "a[href='/nested_frames']")
//    WebElement frameWindows;
//    public HomePage getAlertsFrameWindows() {
//        clickWithJS(frameWindows, 0, 600);
//        return this;
//
//    }

    @FindBy( css = "a[href='/frames']")
    WebElement frames;
    public HomePage selectFrame() {
        click(frames);
        return  this;
    }
    @FindBy(xpath = "//a[normalize-space()='Nested Frames']")
    WebElement nestedFrames;
    public HomePage selectNestedFrames() {
        click(nestedFrames);
        return this;
    }
}


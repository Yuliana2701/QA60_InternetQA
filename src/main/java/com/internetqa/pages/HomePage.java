package com.internetqa.pages;

import com.internetqa.pages.alertsFrameWindows.AlertsPage;
import com.internetqa.pages.alertsFrameWindows.FramesPage;
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

    @FindBy( css = "a[href='/frames']")
    WebElement frames;

    public HomePage selectFrame() {
        clickWithJS(frames,0,300);
        return  this;
    }

    @FindBy(css = "a[href='/iframe']")
    WebElement iFrames;
    public FramesPage selectIFrames() {
      clickWithJS(iFrames,0,300);
        return new FramesPage(driver);
    }
    @FindBy(css= "a[href='/nested_frames']")
    WebElement nestedFrames;
    public FramesPage selectNestedFrames() {
      clickWithJS(nestedFrames,0,300);
       return new  FramesPage(driver);
   }
}



package com.internetqa.pages;

import com.internetqa.pages.alertsFrameWindows.AlertsPage;
import com.internetqa.pages.alertsFrameWindows.FramesPage;
import com.internetqa.pages.widgets.HoversPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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
      click(nestedFrames);
       return new  FramesPage(driver);
   }

    @FindBy(css = "a[href='/horizontal_slider']")
WebElement horizontalSlider;
    public HorizontalSliderPage selectHorizontalSlider() {
        click(horizontalSlider);
        return new HorizontalSliderPage(driver);
    }
    @FindBy(css = "a[href='/hovers']")
    WebElement hovers;

    public HoversPage selectHovers() {
        clickWithJS(hovers, 0, 300);
        return new HoversPage(driver);
    }


    @FindBy(css = "a[href='/context_menu']")
    WebElement contextMenuLink;

    public HomePage selectContextMenu() {
        clickWithJS(contextMenuLink, 0, 300);
        return new HomePage(driver);
    }
    @FindBy(css = "a[href='/dropdown']")
    WebElement dropdownLink;

    public HomePage selectDropdown() {
        clickWithJS(dropdownLink, 0, 300);
        return this;
    }

    @FindBy(css = "a[href='/drag_and_drop']")
    WebElement dragAndDropLink;

    public HomePage selectDragAndDrop() {
        clickWithJS(dragAndDropLink, 0, 300);
        return this;
    }
}



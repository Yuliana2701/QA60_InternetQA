package com.internetqa.pages.alertsFrameWindows;

import com.internetqa.pages.BasePage;
import com.internetqa.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> iframes;

    public FramesPage returnListOfFrames() {
        System.out.println("Total number of iframes: " + iframes.size());
        return this;
    }

    public FramesPage switchToIframeIndex(int index) {
        driver.switchTo().frame(index);
        return this;
    }

    @FindBy(id = "tinymce")
    WebElement iframeText;

    public FramesPage verifyIframeByText(String text) {
        Assert.assertTrue(shouldHaveText(iframeText, text, 5));
        return this;
    }

    @FindBy(id = "mce_0_ifr")
    WebElement iframeById;

    public FramesPage switchToIframeById() {
        driver.switchTo().frame(iframeById);
        return this;
    }

    public FramesPage switchToMainPage() {
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(tagName = "h3")
    WebElement title;

    public FramesPage verifyMainPageByTitle(String text) {
        Assert.assertTrue(title.getText().contains(text));
        return this;
    }

    // тест падает
    @FindBy(tagName = "body")
    WebElement body;

    public FramesPage handleNestedFrames() {
        driver.switchTo().frame(iframeText);// switch to frame1
        //gettext from parent frame
        System.out.println("IFrames is " + body.getText());
        System.out.println("Numbers of inside iframe is " + iframes.size());// number of Iframes in parent
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);// switch to child
        System.out.println("Iframe is " + body.getText());
        driver.switchTo().defaultContent();
        // switch to parent iframe
        driver.switchTo().parentFrame();
        System.out.println("Iframe is " + body.getText());
        return this;

    }
    }





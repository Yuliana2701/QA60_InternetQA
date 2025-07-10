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

    public String middleText;
    public String rightText;
    public String bottomText;



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


    public FramesPage handleNestedFrames() {

            driver.switchTo().frame("frame-top");

            driver.switchTo().frame("frame-middle");
            middleText = driver.findElement(By.id("content")).getText();

            driver.switchTo().parentFrame();

            driver.switchTo().frame("frame-right");
            rightText = driver.findElement(By.tagName("body")).getText();

            driver.switchTo().defaultContent();

            driver.switchTo().frame("frame-bottom");
            bottomText = driver.findElement(By.tagName("body")).getText();

            driver.switchTo().defaultContent();

            return this;
        }
    public FramesPage verifyIFrames(String expectedMiddle, String expectedRight, String expectedBottom) {
        Assert.assertEquals(middleText, expectedMiddle);
        Assert.assertEquals(rightText, expectedRight);
        Assert.assertEquals(bottomText, expectedBottom);
        return this;
    }


}









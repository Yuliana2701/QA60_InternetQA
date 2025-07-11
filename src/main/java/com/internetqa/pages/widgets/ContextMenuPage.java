package com.internetqa.pages.widgets;

import com.internetqa.pages.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContextMenuPage extends BasePage {
    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "hot-spot")
    WebElement contextBox;

    public ContextMenuPage rightClickOnBox() {
        Actions actions = new Actions(driver);
        actions.contextClick(contextBox).perform();
        return this;
    }

    public ContextMenuPage verifyAlertText(String expectedText) {
        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        Assert.assertEquals(actualText, expectedText, "Alert text mismatch!");
        alert.accept();
        return this;
    }
}

package com.internetqa.pages.widgets;

import com.internetqa.pages.BasePage;
import com.internetqa.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class HoversPage extends BasePage {
    public HoversPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "(//div[@class='figure'])[1]")
    WebElement firstFigure;

    @FindBy(xpath = "(//div[@class='figure'])[1]//h5")
    WebElement firstUserName;


    public HoversPage hoverOverFirstFigure() {
        moveWithJS(0, 200);
        new Actions(driver).moveToElement(firstFigure).perform();

        pause(1500);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(firstUserName));

        return this;
    }
    public HoversPage verifyFirstUserName(String expectedName) {
        Assert.assertEquals(firstUserName.getText(), expectedName);
        return this;
    }
}

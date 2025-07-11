package com.internetqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DragAndDropPage extends BasePage{
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }
@FindBy(id = "column-a")
    WebElement columnA;

    @FindBy(id = "column-b")
    WebElement columnB;
    public DragAndDropPage dragAToB() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(columnA, columnB).perform();

        pause(1000);

        return this;
    }

    public DragAndDropPage verifyColumnsSwapped() {
        String textA = columnA.getText();
        String textB = columnB.getText();

        Assert.assertEquals(textA, "B", "Text column A not equal to B after drag and drop");
        Assert.assertEquals(textB, "A", "Text column B not equal to A after drag and drop");

        return this;
    }
}


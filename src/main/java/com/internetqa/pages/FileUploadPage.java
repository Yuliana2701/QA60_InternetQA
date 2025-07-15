package com.internetqa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FileUploadPage extends BasePage{
    public FileUploadPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "file-upload")
    WebElement fileUpload;
    public FileUploadPage selectChooseFile(String path) {
        fileUpload.sendKeys(path);
        return this;
    }

    @FindBy(id = "file-submit")
    WebElement fileSubmit;
    public FileUploadPage clickUploadButton() {
        click(fileSubmit);
        return this;
    }
    @FindBy(css = "div[class='example'] h3")
    WebElement successMessage;

    @FindBy(id = "uploaded-files")
    WebElement uploadedFile;
    public void verifyUploadSuccess(String expectedFileName) {
       Assert.assertEquals(successMessage.getText(), "File Uploaded!");
        Assert.assertEquals(uploadedFile.getText(), expectedFileName);
    }
}

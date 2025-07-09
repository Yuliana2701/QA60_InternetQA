package com.internetqa.tests;

import com.internetqa.pages.HomePage;
import com.internetqa.pages.alertsFrameWindows.FramesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        driver.get("https://the-internet.herokuapp.com");
        new HomePage(driver)
                .selectFrame()
                .selectIFrames();

    }
    @Test
    public void iFrameTest() {
        new FramesPage(driver)
                .returnListOfFrames()
                .switchToIframeIndex(0)
                .verifyIframeByText("Your content goes here.");
    }

    @Test
    public void iFrameTest2() {
        new FramesPage(driver)
                .switchToIframeById()
                .verifyIframeByText("Your content goes here.")
                .switchToMainPage()
                .verifyMainPageByTitle("An iFrame containing the TinyMCE WYSIWYG Editor");
    }
    // тест падает
     @Test
    public void nestedIFramesTest() {
        new HomePage(driver)
                .selectNestedFrames()
                .handleNestedFrames();
    }

}

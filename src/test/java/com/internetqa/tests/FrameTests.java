package com.internetqa.tests;

import com.internetqa.pages.HomePage;
import com.internetqa.pages.alertsFrameWindows.FramesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).selectFrame().selectNestedFrames();
    }
    @Test
    public void frameTest(){
        new FramesPage(driver).returnListOfFrames();
    }
}

package com.internetqa.tests;

import com.internetqa.pages.HomePage;
import com.internetqa.pages.HorizontalSliderPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HorizontalSliderTests extends TestBase {


    @BeforeMethod
    public void precondition() {
        driver.get("https://the-internet.herokuapp.com");
        new HomePage(driver).selectHorizontalSlider();
    }

    @Test
    public void sliderTest() {
        new HorizontalSliderPage(driver).moveSliderInHorizontalDirectory().verifySliderValue("5");
    }
}


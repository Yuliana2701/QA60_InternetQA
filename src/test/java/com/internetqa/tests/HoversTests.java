package com.internetqa.tests;

import com.internetqa.pages.HomePage;
import com.internetqa.pages.widgets.HoversPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoversTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).selectHovers();
    }
    @Test
    public void hoversTest(){
        new HoversPage(driver).hoverOverFirstFigure()
                .verifyFirstUserName("name: user1");
    }
}

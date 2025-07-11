package com.internetqa.tests;

import com.internetqa.pages.HomePage;
import com.internetqa.pages.widgets.ContextMenuPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContextMenuTests extends TestBase{
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectContextMenu();
    }

    @Test
    public void contextMenuTest() {
        new ContextMenuPage(driver)
                .rightClickOnBox()
                .verifyAlertText("You selected a context menu");
    }
}

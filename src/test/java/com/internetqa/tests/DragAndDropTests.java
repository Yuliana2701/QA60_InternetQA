package com.internetqa.tests;

import com.internetqa.pages.DragAndDropPage;
import com.internetqa.pages.HomePage;
import com.internetqa.pages.widgets.HoversPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectDragAndDrop();
    }

    @Test
    public void dragAndDropTest() {
        new DragAndDropPage(driver)
                .dragAToB()
                .verifyColumnsSwapped();
    }
}



package com.internetqa.tests;

import com.internetqa.pages.DropdownListPage;
import com.internetqa.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownListTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectDropdown();
    }

    @Test
    public void dropdownOption2Test() {
        new DropdownListPage(driver)
                .selectOption("Option 2")
                .verifySelectedOption("Option 2");
    }
}

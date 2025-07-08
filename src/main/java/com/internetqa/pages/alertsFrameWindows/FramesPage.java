package com.internetqa.pages.alertsFrameWindows;

import com.internetqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FramesPage extends BasePage {
    public FramesPage(WebDriver driver) {
        super(driver);
    }

@FindBy(tagName = "frame")
       List<WebElement> frame;
        public FramesPage returnListOfFrames() {
            // iframe.size();// by finding all webelements
            System.out.println("The total number"+ frame.size());

            return this;
        }
    }


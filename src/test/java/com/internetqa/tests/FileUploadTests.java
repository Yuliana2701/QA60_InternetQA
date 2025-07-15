package com.internetqa.tests;

import com.internetqa.pages.FileUploadPage;
import com.internetqa.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class FileUploadTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).selectFileUpload().hideIFrames();
    }
    @Test
    public void addFileUploadTest(){

        new FileUploadPage(driver).selectChooseFile("C:\\Tools\\QA60_InternetQA\\image1.jpg")
                .clickUploadButton()
               .verifyUploadSuccess("image1.jpg");

    }
}

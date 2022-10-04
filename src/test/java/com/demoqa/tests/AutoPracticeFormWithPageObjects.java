package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.AutoPracticePageObjects;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutoPracticeFormWithPageObjects {
    AutoPracticePageObjects autoPracticePageObjects = new AutoPracticePageObjects();

    @BeforeAll
    static void configure() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000;

    }

    @Test
    void practiceFormWithMinimumDataTest(){

       autoPracticePageObjects.openPage()
                     .setFirstName("Valentine")
                     .setLastName("Goncharov")
                     .setEmail("vall@mail.ru")
                     .setGender("Male")
                     .setPhoneNumber("7896543210")
                     .setBirthDay("27", "January", "1991")
                     .setSubjects("Economics")
                     .setHobbies("Sports")
                     .uploadFile("1.png")
                     .setAddress("Avenue, str")
                     .setStateCity("NCR", "Delhi")
                     .pressSubmit();
       autoPracticePageObjects.checkResultTableVisible();
        //Start check text
       autoPracticePageObjects.checkResult("Valentine Goncharov")
                .checkResult("vall@mail.ru") //Check out Student Email
                .checkResult("Male") //Check out Gender
                .checkResult("7896543210") //Check out Mobile
                .checkResult("27 January,1991") //Check out Date of Birth
                .checkResult("Economics") //Check out Subjects
                .checkResult("Sports") //Check out Hobbies
                .checkResult("1.png") //Check out Picture
                .checkResult("Avenue, str") //Check out Address
                .checkResult("NCR Delhi")//Check out State and City
               .pressClose();




    }


}


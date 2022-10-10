package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.AutoPracticePageObjects;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.demoqa.testData.UserInformation.*;

public class AutoPracticeFormWithFakerTest {
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
                     .setFirstName(firstName)
                     .setLastName(lastName)
                     .setEmail(email)
                     .setGender(gender)
                     .setPhoneNumber(phoneNumber)
                     .setBirthDay(day, month, year)
                     .setSubjects(subject)
                     .setHobbies(hobby)
                     .uploadFile(picture)
                     .setAddress(streetAddress)
                     .setStateCity(state, city)
                     .pressSubmit();
       autoPracticePageObjects.checkResultTableVisible();
        //Start check text
       autoPracticePageObjects.checkResultTableVisible()
                .checkResultTableData(firstName, lastName, email, gender, phoneNumber, date, subject, hobby,
                        picture, streetAddress, state, city) //Check out Student Email
//                .checkResult() //Check out Gender
//                .checkResult() //Check out Mobile
//                .checkResult() //Check out Date of Birth
//                .checkResult() //Check out Subjects
//                .checkResult() //Check out Hobbies
//                .checkResult() //Check out Picture
//                .checkResult() //Check out Address
//                .checkResult( + " " + )//Check out State and City
                .pressClose();
    }
}


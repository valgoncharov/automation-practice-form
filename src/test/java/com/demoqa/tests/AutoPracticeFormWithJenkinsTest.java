package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.pages.AutoPracticePageObjects;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.demoqa.testData.UserInformation.*;

public class AutoPracticeFormWithJenkinsTest {
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
    void practiceFormWithAttachmentsTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
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
                        picture, streetAddress, state, city)
                .pressClose();
    }
}


package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.demoqa.tests.TestData.*;

public class AutoPracticeFormWithTestDataTest {

    String firstName;
    String lastName;
    String email;
    String phone;
    String day;
    String month;
    String year;

    @BeforeEach
    void prepareTestData(){
         firstName = "Valentine";
         lastName = "Goncharov";
         email = "vall@mail.ru";
         phone = "7896543210";
         day = "27";
         month = "January";
         year = "1991";
    }


    @BeforeAll
    static void configure() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.timeout = 10000; //10 seconds
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        //Configuration.
    }

    @Test
    void practiceFormTest(){
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" +day+ ":not(.react-datepicker__year-select").click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#subjectsInput").setValue("Economics").pressEnter();
        $("#hobbies-checkbox-1").doubleClick();
        $("#uploadPicture").uploadFromClasspath("1.png");
        $("#currentAddress").setValue("Avenue, str");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();//xpath its better (?)

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click(); //Submit
        //Start check text
        $(".table-responsive").shouldHave(text(firstName + " "+ lastName)) //Check out Student Name
                        .shouldHave(text(email)) //Check out Student Email
                        .shouldHave(text("Male")) //Check out Gender
                        .shouldHave(text(phone)) //Check out Mobile
                        .shouldHave(text(day + " " + month + "," + year)) //Check out Date of Birth
                        .shouldHave(text("Economics")) //Check out Subjects
                        .shouldHave(text("Sports")) //Check out Hobbies
                        .shouldHave(text("1.png")) //Check out Picture
                        .shouldHave(text("Avenue, str")) //Check out Address
                        .shouldHave(text("NCR Delhi")); //Check out State and City
        $("#closeLargeModal").click();



    }
}

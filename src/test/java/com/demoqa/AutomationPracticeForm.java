package com.demoqa;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {

    @BeforeAll
    static void configure() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 10000; //10 seconds
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        //Configuration.
    }

    @Test
    void practiceFormTest(){
        open("/automation-practice-form");
        //$("[id=firstName]").setValue("Valentin"); //First Name
        $("#firstName").setValue("Valentine"); //First Name
        $("[id=lastName]").setValue("Goncharov"); //Last Name
        $("#userEmail").setValue("vall@mail.ru"); //eMail
        $("#genterWrapper").$(byText("Male")).click(); //Gender
        $("#userNumber").setValue("7896543210"); //Mobile(10 Digits)
        $("#dateOfBirthInput").click();
        //$("").setValue("27 Jan 1991"); //Date of Birth
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__day--027:not(.react-datepicker__year-select").click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#subjectsInput").setValue("Economics").pressEnter(); //Subjects
        $("#hobbies-checkbox-1").doubleClick(); //Hobbies (?)
        //$("#uploadPicture").click();
        $("#uploadPicture").uploadFromClasspath("1.png");
        //$("#uploadPicture").uploadFromClasspath("C:\\Users\\Валентин\\Pictures\\Screenshots\\1.png"); //Picture Select file
        //$("#uploadPicture").uploadFile(new File("src/test/resources/1.png"));
        $("#currentAddress").setValue("Avenue, str"); //Current Address
        /*$("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click(); //State
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click(); //City
         */

        $x("//input[@id='react-select-3-input']").setValue("NCR").pressEnter();//xpath its better (?)
        $x("//input[@id='react-select-4-input']").setValue("Delhi").pressEnter();

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#submit").click(); //Submit
        //Start check text
        $(".table-responsive").shouldHave(text("Valentine Goncharov")); //Check out Student Name
        $(".table-responsive").shouldHave(text("vall@mail.ru")); //Check out Student Email
        $(".table-responsive").shouldHave(text("Male")); //Check out Gender
        $(".table-responsive").shouldHave(text("7896543210")); //Check out Mobile
        $(".table-responsive").shouldHave(text("27 January,1991")); //Check out Date of Birth
        $(".table-responsive").shouldHave(text("Economics")); //Check out Subjects
        $(".table-responsive").shouldHave(text("Sports")); //Check out Hobbies
        $(".table-responsive").shouldHave(text("1.png")); //Check out Picture
        $(".table-responsive").shouldHave(text("Avenue, str")); //Check out Address
        $(".table-responsive").shouldHave(text("NCR Delhi")); //Check out State and City
        $("#closeLargeModal").click();



    }
}

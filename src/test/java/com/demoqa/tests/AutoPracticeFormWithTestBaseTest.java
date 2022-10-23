package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutoPracticeFormWithTestBaseTest extends TestBase{

    @Test
    void practiceFormTest(){
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Male")).click(); //Gender
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" +day+ ":not(.react-datepicker__year-select").click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#subjectsInput").setValue("Economics").pressEnter(); //Subjects
        $("#hobbies-checkbox-1").doubleClick(); //Hobbies (?)
        $("#uploadPicture").uploadFromClasspath("1.png");
        $("#currentAddress").setValue("Avenue, str"); //Current Address

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

package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.demoqa.pages.components.CalendarComponents;
import com.demoqa.pages.components.ResultModal;
import com.demoqa.pages.components.StateComponents;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutoPracticePageObjects {
    //Elements
    private CalendarComponents calendarComponents = new CalendarComponents();
    private ResultModal resultModal = new ResultModal();
    private StateComponents stateComponents = new StateComponents();

    private SelenideElement
            firstNameInput =  $("#firstName"),
            lastNameInput =  $("#lastName"),
            emailInput = $("#userEmail"),
            phoneNumber = $("#userNumber"),
            hobbiesInput = $("#hobbiesWrapper"),
            subjectsInput = $("#subjectsInput"),
            addressInput = $("#currentAddress");
    private final static String TITLE_TEXT = "Student Registration Form";

    //Actions
    public AutoPracticePageObjects openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public AutoPracticePageObjects setFirstName(String value){
        firstNameInput.setValue(value); //First Name

        return this;
    }
//Example
//    public AutoPracticePageObjects clearFirstName(String value){
//        $("#firstName").clear(); //First Name
//
//        return this;
//    }

    public AutoPracticePageObjects setLastName(String value){
        lastNameInput.setValue(value); //Last Name

        return this;
    }

    public AutoPracticePageObjects setEmail(String value){
        emailInput.setValue(value); //eMail

        return this;
    }

    public AutoPracticePageObjects setGender(String value){
        $("#genterWrapper").$(byText(value)).click(); //Gender

        return this;
    }

    public AutoPracticePageObjects setPhoneNumber(String value){
        phoneNumber.setValue(value); //Mobile(10 Digits)

        return this;
    }

    public AutoPracticePageObjects setBirthDay(String day, String month, String year){
        calendarComponents.setDate(day, month, year);

        return this;
    }
    public AutoPracticePageObjects setHobbies(String value){
        hobbiesInput.$(byText(value)).click();
        $("#hobbies-checkbox-1").doubleClick(); //Hobbies (?)

        return this;
    }
    public AutoPracticePageObjects setSubjects(String value){
        subjectsInput.setValue(value).pressEnter();

        return this;
    }
    public AutoPracticePageObjects uploadFile(String value){
        $("#uploadPicture").uploadFromClasspath(value);

        return this;
    }
    public AutoPracticePageObjects setAddress(String value){
        addressInput.setValue(value); //Current Address

        return this;
    }
    public AutoPracticePageObjects setStateCity(String state, String city){
        stateComponents.setStateAndCity(state, city);

        return this;
    }
    public AutoPracticePageObjects pressSubmit(){
        $("#submit").click(); //Submit

        return this;
    }
    public AutoPracticePageObjects checkResultTableVisible(){
        resultModal.checkVisible();

        return this;
    }
    public AutoPracticePageObjects checkResultTableData(String... strings){ // String key,
       resultModal.checkResult(strings); //key,

        return this;
    }
    public AutoPracticePageObjects pressClose(){
        $("#closeLargeModal").click();

        return this;
    }
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot(){
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);


    }


}

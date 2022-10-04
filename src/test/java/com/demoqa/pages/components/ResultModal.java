package com.demoqa.pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultModal {

    private final static String TITLE_TEXT = "Thanks for submitting the form";

    public ResultModal checkVisible() {
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(TITLE_TEXT));
        return this;

    }
//    public ResultModal setDate(String day, String month, String year) {
//        $(".react-datepicker__month-select").selectOption(month);
//        $(".react-datepicker__year-select").selectOption(year);
//        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__year-select").click();
//        return this;
//
//    }

    public void checkResult(String value) { //String key,
        $(".table-responsive").shouldHave(text(value)); //Check out Student Name
    }
}

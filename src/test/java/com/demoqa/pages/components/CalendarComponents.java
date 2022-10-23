package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.*;

public class CalendarComponents {

    public CalendarComponents setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__year-select").click();
        return this;
    }

}

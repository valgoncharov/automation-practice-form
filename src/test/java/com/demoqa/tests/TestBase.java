package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    String firstName = "Valentine",
            lastName = "Goncharov",
            email = "vall@mail.ru",
            phone = "7896543210",
            day = "27",
            month = "January",
            year = "1991";

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
}

package com.demoqa.testData;

import com.github.javafaker.Faker;

public class UserInformation {
    private static final Faker faker = new Faker();

    public static String firstName = faker.name().firstName(); // Emory
    public static String lastName = faker.name().lastName(); // Barton
    public static String email = faker.internet().emailAddress();
    public static String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    public static String gender = faker.demographic().sex();
    public static String picture = "1.png";
    public static String hobby = "Sports";
    public static String subject = "Economics";
    public static String streetAddress = faker.address().streetAddress();
    public static String state = "NCR";
    public static String city = "Delhi";
    public static String day = "27";
    public static String month = "January";
    public static String year = "1991";
    public static String date = day + " " + month + "," + year;





}

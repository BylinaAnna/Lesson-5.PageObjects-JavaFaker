package com.demoqa;

import com.github.javafaker.Faker;
import com.demoqa.components.CalendarComponent;
import com.demoqa.page.RegistrationPage;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class PracticeFormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    CalendarComponent calendarComponent = new CalendarComponent();
    Faker rufaker = new Faker(new Locale("ru"));
    Faker ukfaker = new Faker(new Locale("en-GB"));

    String firstname = rufaker.name().firstName();
    String lastname = rufaker.name().lastName();
    String usermail = ukfaker.internet().emailAddress();
    String gender = "Female";
    String mobile = rufaker.phoneNumber().subscriberNumber(10);
    String address = ukfaker.address().fullAddress();
    String file_photo = "img/test.png";

    @Test
    void fillFormTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName(firstname)
                .typeLastName(lastname)
                .typeUserEmail(usermail)
                .typeGender(gender)
                .typeMobile(mobile);
        calendarComponent.setDate("05", "January", "1984");
        registrationPage.chooseSubject("English")
                .chooseSubject("Maths");
        registrationPage.chooseHobby("Music");
        registrationPage.uploadPic(file_photo);
        registrationPage.typeAddress(address);
        registrationPage.chooseState("NCR");
        registrationPage.chooseCity("Delhi");
        registrationPage.pressSubmit();
        registrationPage.checkFields(firstname + ' ' + lastname, usermail, gender, mobile, "05 January,1984",
                "English, Maths", "Music", "test.png", "Lunacharskogo,10", "NCR Delhi");
    }
}
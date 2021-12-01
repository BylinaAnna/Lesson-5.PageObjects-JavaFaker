package com.demoqa.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class RegistrationPage {
    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            gender = $("#genterWrapper"),
            mobile = $("#userNumber"),
            subjects = $("#subjectsInput"),
            address = $("#currentAddress"),
            stateCity = $("#stateCity-wrapper"),
            state = $("#state"),
            city = $("#city"),
            submit = $("#submit"),
            checkfields = $(".table-responsive");

    public void openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public RegistrationPage typeFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public RegistrationPage typeUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public RegistrationPage typeGender(String value) {
        gender.$(byText(value)).click();
        return this;
    }

    public RegistrationPage typeMobile(String value) {
        mobile.setValue(value);
        return this;
    }

    public RegistrationPage chooseSubject(String value) {
        subjects.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage chooseHobby(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPic(String value) {
        $("#uploadPicture").uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage typeAddress(String value) {
        address.setValue(value);
        address.scrollIntoView(true);
        return this;
    }

    public RegistrationPage chooseState(String value) {
        state.click();
        stateCity.$(byText(value)).click();
        return this;
    }

    public RegistrationPage chooseCity(String value) {
        city.click();
        stateCity.$(byText(value)).click();
        return this;
    }

    public RegistrationPage pressSubmit() {
        submit.click();
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public RegistrationPage checkFields(String FIO, String email, String gender, String mobile,
                                        String date, String subjects, String hobby, String pic,
                                        String address, String statecity) {

        checkfields.shouldHave(text(FIO), text(email), text(gender),
                text(mobile), text(date), text(subjects), text(hobby), text(pic),
                text(address), text(statecity));
        return this;
    }
}

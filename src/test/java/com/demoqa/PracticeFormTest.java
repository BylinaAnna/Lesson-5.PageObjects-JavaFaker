package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Condition.text;




public class PracticeFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;
    }
    @AfterAll
    static void afterAll() {
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Petrova");
        $("#userEmail").setValue("chaika@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("7903627451");
        $("#userNumber").setValue("7903627451");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1984");
        $x("//div[contains(@aria-label, \"January 5th, 1984\")]").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/test.png");
        $("#currentAddress").setValue("Lunacharskogo,10");
        $("#currentAddress").scrollIntoView(true);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Anna Petrova"),text("chaika@gmail.com"),text("Female"),
                text("7903627451"),text("05 January,1984"),text("English, Maths"),text("Music"),text("test.png"),
                text("test.png"),text("Lunacharskogo,10"),text("NCR Delhi"));





}
}
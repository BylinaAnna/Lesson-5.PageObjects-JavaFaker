package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;




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




}
}
package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.files.DownloadActions.click;


public class PracticeFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Petrova");
        $("#userEmail").setValue("chaika@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        //$("#lastName").setValue("Petrova");

}
}
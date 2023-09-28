package lesson3.tests;

import com.codeborne.selenide.Condition;
import driver.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static constants.DataConstants.*;

public class SuccessfulFillingFormTest extends BaseTest {

    @Test
    public void successFillFormTest() {
        open(urlForm);
        Assertions.assertTrue(url().contains(urlForm));

        $("[placeholder='John']").setValue(nameUser);
        $("[placeholder='Snow']").setValue(lastnameUser);
        $("[placeholder='name@example.com']").setValue(emailUser);
        $("[name='phone']").setValue("2053454545");

        $x("//label[text() = 'Language']/parent::div").click();
        $("[data-value='Russian']").click();

//        $("[data-testid='CalendarIcon']").click(); Не смог разобраться

        $("[value='Male']").click();
        $("[value='Music']").click();

        $x("//label[text() = 'Subjects']/parent::div").click();
        $("[data-value='Music']").click();
        $("[data-value='Sports']").click();
        $("[id='menu-']").click();

        $x("//label[text() = 'State']/parent::div").click();
        $x("//li[text() = 'Mississippi']").click();

        $x("//label[text() = 'City']/parent::div").click();
        $x("//li[text() = 'Jackson']").click();

        $(".MuiSlider-thumb").lastChild().setValue("50");

        $("[style='height: 84px; overflow: hidden;']").setValue(address);

//        $("[type='file']").uploadFromClasspath("207.png"); Не смог разобраться

        $("[type='submit']").scrollTo().click();

        $x("//h4[text() = 'Thank you for submitting the form']").scrollTo().shouldBe(Condition.visible);
        $x("//h4[text() = 'Thank you for submitting the form']/parent::div").shouldBe(text(nameUser));
        $x("//h4[text() = 'Thank you for submitting the form']/parent::div").shouldBe(text(lastnameUser));
        $x("//h4[text() = 'Thank you for submitting the form']/parent::div").shouldBe(text(emailUser));
        $x("//h4[text() = 'Thank you for submitting the form']/parent::div").shouldBe(text("Male"));
        $x("//h4[text() = 'Thank you for submitting the form']/parent::div").shouldBe(text("+1 205 345 4545"));
        $x("//h4[text() = 'Thank you for submitting the form']/parent::div").shouldBe(text("Music"));
        $x("//h4[text() = 'Thank you for submitting the form']/parent::div").shouldBe(text("Music, Sports"));
        $x("//h4[text() = 'Thank you for submitting the form']/parent::div").shouldBe(text("50"));
        $x("//h4[text() = 'Thank you for submitting the form']/parent::div").shouldBe(text("Russian"));
        $x("//h4[text() = 'Thank you for submitting the form']/parent::div").shouldBe(text(address));
    }
}

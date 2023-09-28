package lesson8.test;

import com.codeborne.selenide.Condition;
import driver.BaseTest;
import lesson8.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static constants.DataConstants.*;

/**
 * @author mateenkov
 */

public class RegistrationFormTest extends BaseTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void registrationFormTest() {
        registrationFormPage.openPage()
                .setFirstName(nameUser)
                .setLastName(lastnameUser)
                .setGender()
                .setEmailUser(emailUser)
                .setNumberPhone(numberUser)
                .setDateBirth("18", "August", "1998")
                .setSubject("Physics")
                .setHobbies("Reading")
                .uploadPicture("207.png")
                .setAddress("Some Address")
                .setState("Haryana")
                .setCity("Karnal")
                .pressSubmit();

        registrationFormPage.checkTitleTableAndTableResult("Thanks for submitting the form")
                .checkResults("Student Name", "Ilya Mateenkov")
                .checkResults("Student Email", "imateenkow@gmail.com")
                .checkResults("Gender", "Male")
                .checkResults("Mobile", "8920317050")
                .checkResults("Date of Birth", "18 August,1998")
                .checkResults("Subjects", "Physics")
                .checkResults("Hobbies", "Reading")
                .checkResults("Picture", "207.png")
                .checkResults("Address", "Some Address")
                .checkResults("State and City", "Haryana Karnal");
    }
}

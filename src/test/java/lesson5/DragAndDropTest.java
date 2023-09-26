package lesson5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

/**
 * @author mateenkov
 */

public class DragAndDropTest {

    SelenideElement a = $("#column-a");
    SelenideElement b = $("#column-b");

    @BeforeEach
    void setUp() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void dragAndDropTest() {
        open("/drag_and_drop");

        a.shouldHave(Condition.text("A"));
        b.shouldHave(Condition.text("B"));

        a.dragAndDropTo(b);

        a.shouldHave(Condition.text("B"));
        b.shouldHave(Condition.text("A"));

    }

    @AfterEach
    void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
}

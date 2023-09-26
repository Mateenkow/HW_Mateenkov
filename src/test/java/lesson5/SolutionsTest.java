package lesson5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author mateenkov
 */

public class SolutionsTest {

    @BeforeEach
    void setUp() {
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void solutionsTest() {
        open("/");

        $(byTagAndText("button", "Solutions")).hover();

        $(".header-menu-wrapper").$(byTagAndText("a", "Enterprise")).click();

        $(".application-main ").shouldHave(Condition.text("Build like the best"));

    }

    @AfterEach
    void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
}

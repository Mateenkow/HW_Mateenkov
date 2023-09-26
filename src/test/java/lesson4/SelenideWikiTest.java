package lesson4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author mateenkov
 */

public class SelenideWikiTest {

    @BeforeEach
    void setUp() {
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void selenideWikiTest() {
        open("/selenide/selenide");

        $("#wiki-tab").click();

        $("[href='#welcome-to-the-selenide-wiki']").shouldBe(Condition.visible);
        $("[href='#welcome-to-the-selenide-wiki']").shouldHave(Condition
                .exactText("Welcome to the selenide wiki!"));

        $("[data-filterable-for='wiki-pages-filter']").lastChild()
                .shouldBe(Condition.exist);

        $("#wiki-pages-filter").setValue("SoftAssertions");
        $x("//details/summary/div/span/a[text() ='SoftAssertions']").click();

        $("[data-filterable-for='wiki-pages-filter']").lastChild().click();

        $("#wiki-wrapper").shouldHave(Condition.text("SoftAssertions"));

        $("#user-content-3-using-junit5-extend-test-class").shouldBe(Condition.exist);
        $("#user-content-3-using-junit5-extend-test-class").scrollTo();
        $("#user-content-3-using-junit5-extend-test-class")
                .shouldHave(Condition.text("Junit5"));

        $(".markdown-body").shouldHave(Condition.text("3. Using JUnit5 extend test class:"));
        $(".markdown-body").shouldHave(Condition.text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));

        $(byText("Or register extension inside test class:")).shouldBe(Condition.visible);
        $(".markdown-body").shouldHave(Condition.text("class Tests {\n" +
                "  @RegisterExtension \n" +
                "  static SoftAssertsExtension softAsserts = new SoftAssertsExtension();\n" +
                "\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));

    }

    @AfterEach
    void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
}

package lesson4;

import com.codeborne.selenide.Condition;
import lesson3.driver.BaseTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

/**
 * @author mateenkov
 */

public class SelenideWikiTest extends BaseTest {

    @Test
    void selenideWikiTest() {
        open("https://github.com/selenide/selenide");

        $("[id='wiki-tab']").click();

        $("[href='#welcome-to-the-selenide-wiki']").shouldBe(Condition.visible);
        $("[href='#welcome-to-the-selenide-wiki']").shouldHave(Condition
                .exactText("Welcome to the selenide wiki!"));

        $("[data-filterable-for='wiki-pages-filter']").lastChild()
                .shouldBe(Condition.exist);

        $("[id='wiki-pages-filter']").setValue("SoftAssertions");
        $x("//details/summary/div/span/a[text() ='SoftAssertions']").click();

        $("[data-filterable-for='wiki-pages-filter']").lastChild().click();

        $("[id='wiki-wrapper']").shouldHave(Condition.text("SoftAssertions"));

        $("[id='user-content-3-using-junit5-extend-test-class']").shouldBe(Condition.exist);
        $("[id='user-content-3-using-junit5-extend-test-class']").scrollTo();
        $("[id='user-content-3-using-junit5-extend-test-class']")
                .shouldHave(Condition.text("Junit5"));
        String code = $x("//a[@href= '#3-using-junit5-extend-test-class']/following::div/pre")
                .getText();

        System.out.println(code);

    }
}

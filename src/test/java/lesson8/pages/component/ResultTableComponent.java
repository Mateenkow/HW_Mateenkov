package lesson8.pages.component;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * @author mateenkov
 */

public class ResultTableComponent {
    public void checkResult(String key, String value) {
        $(".modal-body").$(byText(key)).parent().shouldBe(Condition.text(value));
    }
}

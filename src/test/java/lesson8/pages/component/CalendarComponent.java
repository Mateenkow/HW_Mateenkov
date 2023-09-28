package lesson8.pages.component;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

/**
 * @author mateenkov
 */

public class CalendarComponent {
    public void setDateBirth(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(byTagAndText("div", day)).click();
    }
}

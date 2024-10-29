package pages.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTableComponent {
    public static void checkResults(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }
    public static void checkResultIsNotVisible(){
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);
    }
}
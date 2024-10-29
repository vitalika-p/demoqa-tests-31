import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanov@email.com");
        actions().moveToElement($("#gender-radio-1")).click().build().perform();
        $("#userNumber").setValue("1234567891");
        actions().moveToElement($("#dateOfBirthInput")).click().build().perform();
        $(".react-datepicker__month-select").$(byText("December")).click();
        $(".react-datepicker__year-select").$(byText("1989")).click();
        $(".react-datepicker__day.react-datepicker__day--17").click();
        $("#subjectsInput").setValue("B").sendKeys(Keys.ENTER);
        $("#hobbies-checkbox-2").parent().click();
        $("#hobbies-checkbox-3").parent().click();
        $("#uploadPicture").uploadFromClasspath("image.png");
        $("#currentAddress").setValue("Tverskaya,100");
        $("#state").click();
        $("#react-select-3-input").setValue("N").sendKeys(Keys.ENTER);
        $("#city").click();
        $("#react-select-4-input").setValue("D").sendKeys(Keys.ENTER);
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Ivan"));
        $(".table-responsive").shouldHave(text("Ivanov"));
        $(".table-responsive").shouldHave(text("ivanov@email.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1234567891"));
        $(".table-responsive").shouldHave(text("17 December,1989"));
        $(".table-responsive").shouldHave(text("Biology"));
        $(".table-responsive").shouldHave(text("Reading"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("image.png"));
        $(".table-responsive").shouldHave(text("Tverskaya,100"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));
    }
}
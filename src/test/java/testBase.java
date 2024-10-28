import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.registrationPage;

public class testBase {

    pages.registrationPage registrationPage = new registrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }
}
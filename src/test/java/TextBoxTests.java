import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import static io.qameta.allure.Allure.step;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

@Tag("Smoke")
@Tag("Заполнение формы регистрации")
@Test
    void textBoxPageTest() {
    step("Открыть страницу с формой", () -> {
        textBoxPage.openTextPage();
    });

    step("Заполнить поля", () -> {
    textBoxPage
            .setFullName("Mr.Bin")
            .setUserEmail("misterbin@internet.com")
            .setCurrentAddress("London,Oxford street")
            .setPermanentAddress("New York,USA");
    });

    step("Отправить форму", () -> {
        textBoxPage.submit();
    });

    step("Проверить отображение полей", () -> {
    textBoxPage.
            checkResult("Mr.Bin", "misterbin@internet.com", "London,Oxford street","New York,USA" );
});
    }

}

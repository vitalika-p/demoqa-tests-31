import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

@Test
    void textBoxPageTest() {
    textBoxPage
            .openTextPage()
            .setFullName("Mr.Bin")
            .setUserEmail("misterbin@internet.com")
            .setCurrentAddress("London,Oxford street")
            .setPermanentAddress("New York,USA")
            .submit();

    textBoxPage.
            checkResult("Mr.Bin", "misterbin@internet.com", "London,Oxford street","New York,USA" );
    }

}

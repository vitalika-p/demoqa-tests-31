import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleJUnitTest {

    int result;

    @BeforeAll
    static void beforeAll() {
        System.out.println("###   beforeAll()\n");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("###     beforeEach");
        result = getResult();
    }

    @AfterEach
    void afterEach() {
        System.out.println("###     afterEach()\n");
        result = 0;
    }

    @AfterAll
    static void afterAll() {
        System.out.println("###   afterAll()\n");
    }

    @Test
    void firstTest() {
        System.out.println("###     firstTest");
        Assertions.assertTrue(result >2);
    }

    @Test
    void secondTest() {
        int result = getResult();
        System.out.println("###     secondTest");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void thirdTest() {
        int result = getResult();
        System.out.println("###     thirdTest");
        Assertions.assertTrue(result > 2);
    }

    private int getResult() {
        return 3;
    }

}

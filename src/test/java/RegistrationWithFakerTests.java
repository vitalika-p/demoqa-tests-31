import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;
import java.util.Locale;
import static io.qameta.allure.Allure.step;
import static utils.RandomUtils.getRandomCityByState;

public class RegistrationWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker(new Locale("de"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userGender = faker.options().option("Male", "Female", "Other");
    String userNumber = faker.phoneNumber().subscriberNumber(10);
    String invalidUserNumber = faker.phoneNumber().subscriberNumber(9);
    String userAddress = faker.address().streetAddress();
    String userSubject = faker.options().option("Accounting", "Maths", "Arts", "Social Studies", "Chemistry", "Computer Science", "Commerce", "Physics", "Economics");
    String userInterest = faker.options().option("Sports", "Reading", "Music");
    String picturePath = RandomUtils.getRandomFile();
    String userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    String userCity = getRandomCityByState(userState);
    String userBirthYear = String.valueOf(faker.number().numberBetween(1950, 2015));
    String userBirthMonth = RandomUtils.setRandomValue("January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December");
    String userBirthDay = String.valueOf(faker.number().numberBetween(1,31));

    @Tag("Smoke")
    @Tag("Заполнение формы регистрации")
    @Test
    void fillFullFormTest() {
        step("Открыть страницу с формой", () -> {
            registrationPage.openPage() .removeBanners();
        });

        step("Заполнить поля", () -> {
        registrationPage
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setDateOfBirth(userBirthDay, userBirthMonth, userBirthYear)
                .setSubject(userSubject)
                .setHobby(userInterest)
                .setPicture(picturePath)
                .setCurrentAddress(userAddress)
                .setState(userState)
                .setCity(userCity);
        });

        step("Отправить форму", () -> {
            registrationPage .submit();
        });

        step("Проверить отображение полей в таблице", () -> {
        registrationPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", userBirthDay + " " + userBirthMonth + "," + userBirthYear)
                .checkResult("Subjects", userSubject)
                .checkResult("Hobbies", userInterest)
                .checkResult("Picture", picturePath)
                .checkResult("Address", userAddress)
                .checkResult("State and City", userState + " " + userCity);
        });
    }

    @Tag("Smoke")
    @Tag("Заполнение минимального количества полей")
    @Test
    void minimalFormTest(){
        step("Открыть страницу с формой", () -> {
            registrationPage.openPage() .removeBanners();
        });

        step("Заполнить поля", () -> {
        registrationPage
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(userNumber);
        });

        step("Отправить форму", () -> {
            registrationPage .submit();
        });

        step("Проверить отображение полей в таблице", () -> {
        registrationPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", userGender);
        });
    }

    @Tag("Simple")
    @Tag("Некорректный номер телефона")
    @Test
    void invalidNumberTest(){
        step("Открыть страницу с формой", () -> {
            registrationPage.openPage() .removeBanners();
        });

        step("Заполнить поля", () -> {
        registrationPage
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(invalidUserNumber)
                .setDateOfBirth(userBirthDay, userBirthMonth, userBirthYear);
        });
        step("Отправить форму", () -> {
            registrationPage .submit();
        });
        step("Проверить отображение полей в таблице", () -> {
        registrationPage.checkNoResults();
        });
    }
}
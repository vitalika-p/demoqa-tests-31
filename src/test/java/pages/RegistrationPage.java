package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.components.CalendarComponent;
import pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateComponent = $("#state"),
            stateComponent2 =$("#react-select-3-input"),
            cityComponent = $("#city"),
            cityComponent2 = $("#react-select-4-input"),
            responseMessage = $(".h3-response"),
            submitButton = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectsInput.setValue(subject).sendKeys(Keys.ENTER);
        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage setPicture(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public RegistrationPage setState(String state) {
        stateComponent.click();
        stateComponent2.setValue(state).sendKeys(Keys.ENTER);
        return this;
    }

    public RegistrationPage setCity(String city) {
        cityComponent.click();
        cityComponent2.setValue(city).sendKeys(Keys.ENTER);
        return this;
    }

    public RegistrationPage submit() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        ResultsTableComponent.checkResults(key, value);

        return this;
    }

    public RegistrationPage checkNoResults(){
        ResultsTableComponent.checkResultIsNotVisible();


        return this;
    }

}
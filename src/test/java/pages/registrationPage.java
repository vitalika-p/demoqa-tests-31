package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.components.calendarComponent;
import pages.components.resultsTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class registrationPage {

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
            submitButton = $("#submit");

    pages.components.calendarComponent calendarComponent = new calendarComponent();
    resultsTableComponent resultsTable = new resultsTableComponent();

    public registrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public registrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public registrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public registrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public registrationPage setUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public registrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public registrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public registrationPage setSubject(String subject) {
        subjectsInput.setValue(subject).sendKeys(Keys.ENTER);
        return this;
    }

    public registrationPage setHobby(String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();
        return this;
    }

    public registrationPage setPicture(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }

    public registrationPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public registrationPage setState(String state) {
        stateComponent.click();
        stateComponent2.setValue(state).sendKeys(Keys.ENTER);
        return this;
    }

    public registrationPage setCity(String city) {
        cityComponent.click();
        cityComponent2.setValue(city).sendKeys(Keys.ENTER);
        return this;
    }

    public registrationPage submit() {
        submitButton.click();
        return this;
    }

    public registrationPage checkResult(String key, String value) {
        resultsTable.checkTableValue(key, value);
        return this;
    }

    public registrationPage checkNoResults(String key) {
        resultsTable.checkTableValueIsEmpty(key);
        return this;
    }

}

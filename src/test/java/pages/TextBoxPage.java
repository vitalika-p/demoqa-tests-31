package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

    private final SelenideElement fullNameInput = $("#userName"),
        userEmailInput = $("#userEmail"),
        currentAddressInput = $("#currentAddress"),
        permanentAddressInput = $("#permanentAddress"),
        submitButton = $("#submit"),
        nameOutput = $("#output #name"),
        emailOutput = $("#output #email"),
        currentAddressOutput =  $("#output #currentAddress"),
        permanentAddressOutput = $("#output #permanentAddress");

    public TextBoxPage openTextPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setFullName (String value) {
        fullNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }
    public TextBoxPage submit() {
        submitButton.click();
        return this;
    }

    public TextBoxPage checkResult(String name, String email, String currentAddress, String permanentAddress){
        nameOutput.shouldHave(Condition.text(name));
        emailOutput.shouldHave(Condition.text(email));
        currentAddressOutput.shouldHave(Condition.text(currentAddress));
        permanentAddressOutput.shouldHave(Condition.text(permanentAddress));

        return this;
    }

}

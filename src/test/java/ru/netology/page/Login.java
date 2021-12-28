package ru.netology.page;

import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class Login {
    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        $("[data-test-id=login] input").setValue(info.getLogin());
        $("[data-test-id=password] input").setValue(info.getPassword());
        $("[data-test-id=action-login]").click();
        return new VerificationPage();
    }

    public void invalidLogin(DataHelper.AuthInfo info) {
        $("[data-test-id=login] input").sendKeys(info.getLogin());
        $("[data-test-id=password] input").sendKeys(info.getPassword());
    }

    public void button() {
        $("[data-test-id=action-login]").click();
    }

    public void error() {
        $(withText("Пользователь заблокирован")).shouldBe(visible);
    }

}

package ru.netology;


import com.github.javafaker.Faker;
import lombok.SneakyThrows;

import org.junit.jupiter.api.Test;

import java.sql.DriverManager;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Forms {


        @Test
        public void formTest() {
            open("http://localhost:9999");
            $("[data-test-id='login'] .input__control").setValue("vasya");
            $("[data-test-id='password'] .input__control").setValue("qwerty123");
            $(withText("Продолжить")).click();
            $(byText("Код из SMS или Push")).shouldBe(appear);
            var code = DataHelper.getValidVerificationCode().getCode();
            $("[data-test-id='code'] .input__control").setValue(code);
            $(withText("Продолжить")).click();
            $(byText("Личный кабинет")).shouldBe(appear);
        }

    @Test
    public void formTestLoginNegative() {
        open("http://localhost:9999");
        $("[data-test-id='login'] .input__control").setValue("olya");
        $("[data-test-id='password'] .input__control").setValue("qwerty123");
        $(withText("Продолжить")).click();
        $(withText("Продолжить")).click();
        $(withText("Продолжить")).click();
        $(withText("Ошибка")).shouldBe(hidden);

    }
    }


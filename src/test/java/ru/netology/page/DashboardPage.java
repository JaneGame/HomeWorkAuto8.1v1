package ru.netology.page;

import com.codeborne.selenide.Condition;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    public void dashboard() {
        $("[data-test-id=dashboard]").shouldBe(Condition.visible);
    }
}

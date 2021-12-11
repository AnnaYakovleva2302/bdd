package ru.netology.dashboard.pages;

import com.codeborne.selenide.SelenideElement;
import ru.netology.dashboard.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class VerificationPage {
    private SelenideElement verifyField = $("[data-test-id=code] input");
    private SelenideElement verifyButton  = $("[data-test-id=action-verify]");

    public DashboardPage verifyValidCode(DataHelper.VerificationCode code) {
        verifyField.setValue(code.getCode());
        verifyButton.click();
        return page(DashboardPage.class);
    }
}

package ru.netology.dashboard.pages;

import com.codeborne.selenide.SelenideElement;
import ru.netology.dashboard.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class TransferFundsPage {
    private SelenideElement amount = $("[data-test-id=amount] input");
    private SelenideElement fromCard = $("[data-test-id=from] input");
    private SelenideElement transferButton = $("[data-test-id=action-transfer]");

    public DashboardPage transfer(int sum, int number) {
        amount.setValue(Integer.toString(sum));
        if (number == 0) {
            fromCard.setValue(DataHelper.getCardsInfo().getFirst());
        }
        if (number == 1) {
            fromCard.setValue(DataHelper.getCardsInfo().getSecond());
        }
        transferButton.click();
        return page(DashboardPage.class);
    }
}

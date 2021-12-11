package ru.netology.dashboard.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Selenide.*;

public class DashboardPage {
    private SelenideElement firstCard = $("li:nth-child(1) .button");
    private SelenideElement secondCard = $("li:nth-child(2) .button");
    private ElementsCollection cards = $$(".list__item");
    private final String balanceStart = "баланс: ";
    private final String balanceEnd = " р.";

    public DashboardPage() {
    }

    public TransferFundsPage selectCard(int index) {
        if (index == 0) {
            firstCard.click();
        }
        else {
            secondCard.click();
        }
        return page(TransferFundsPage.class);
    }

    public int getBalance(int index) {
        val text = cards.get(index).text();
        return extractBalance(text);
    }

    public int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceEnd);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }
}

package ru.netology.dashboard.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.dashboard.data.DataHelper;
import ru.netology.dashboard.pages.DashboardPage;
import ru.netology.dashboard.pages.LoginPage;
import ru.netology.dashboard.pages.TransferFundsPage;
import ru.netology.dashboard.pages.VerificationPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferFundsTest {
    @BeforeEach
    public void setUpAll() {
        open("http://localhost:9999");
    }

    @Test
    public void shouldTransferFundsToFirstCard() {
        int sumToTransfer = 5000;
        int targetCardIndex = 0;
        int sourceCardIndex = 1;
        LoginPage login = new LoginPage();
        DataHelper.AuthInfo user = DataHelper.getAuthInfo();
        VerificationPage verification = login.validLogin(user);
        DataHelper.VerificationCode code = DataHelper.getVerificationCode();
        DashboardPage dashboard = verification.verifyValidCode(code);
        int targetBalance = dashboard.getBalance(targetCardIndex);
        int sourceBalance = dashboard.getBalance(sourceCardIndex);
        TransferFundsPage transferFunds = dashboard.selectCard(targetCardIndex); // number starts from 0
        transferFunds.transfer(sumToTransfer, sourceCardIndex);
        assertEquals(targetBalance + sumToTransfer, dashboard.getBalance(targetCardIndex));
        assertEquals(sourceBalance - sumToTransfer, dashboard.getBalance(sourceCardIndex));
    }

    @Test
    public void shouldTransferFundsToSecondCard() {
        int sumToTransfer = 5000;
        int targetCardIndex = 1;
        int sourceCardIndex = 0;
        LoginPage login = new LoginPage();
        DataHelper.AuthInfo user = DataHelper.getAuthInfo();
        VerificationPage verification = login.validLogin(user);
        DataHelper.VerificationCode code = DataHelper.getVerificationCode();
        DashboardPage dashboard = verification.verifyValidCode(code);
        int targetBalance = dashboard.getBalance(targetCardIndex);
        int sourceBalance = dashboard.getBalance(sourceCardIndex);
        TransferFundsPage transferFunds = dashboard.selectCard(targetCardIndex); // number starts from 0
        transferFunds.transfer(sumToTransfer, sourceCardIndex);
        assertEquals(targetBalance + sumToTransfer, dashboard.getBalance(targetCardIndex));
        assertEquals(sourceBalance - sumToTransfer, dashboard.getBalance(sourceCardIndex));
    }
}

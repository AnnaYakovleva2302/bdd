package ru.netology.dashboard.data;

import lombok.Value;

public class DataHelper {

    private DataHelper() {
    }

    @Value
    public static class CardsInfo {
        private String first;
        private String second;
    }

    public static CardsInfo getCardsInfo() {
        String firstNumber = "5559 0000 0000 0001";
        String secondNumber = "5559 0000 0000 0002";
        return new CardsInfo(firstNumber, secondNumber);
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        String login = "vasya";
        String pass = "qwerty123";
        return new AuthInfo(login, pass);
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCode() {
        return new VerificationCode("12345");
    }
}
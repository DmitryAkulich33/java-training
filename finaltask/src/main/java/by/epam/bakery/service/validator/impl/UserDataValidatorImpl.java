package by.epam.bakery.service.validator.impl;

import by.epam.bakery.service.validator.api.UserDataValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDataValidatorImpl implements UserDataValidator {
    private static final String REGEX_SURNAME = "(^[A-Z][a-z]{0,35}(-[A-Z])*[a-z]{0,35}$)|(^[А-Я][а-я]{0,35}(-[А-Я])*[а-я]{0,35}$)|(^[A-Z][a-z]{0,70}$)|(^[А-Я][а-я]{0,70}$)";
    private static final String REGEX_NAME = "(^[A-Z][a-z]{0,35}(-[A-Z])*[a-z]{0,35}$)|(^[А-Я][а-я]{0,35}(-[А-Я])*[а-я]{0,35}$)|(^[A-Z][a-z]{0,70}$)|(^[А-Я][а-я]{0,70}$)";
    private static final String REGEX_PATRONYMIC = "(^[A-Z][a-z]{0,35}(-[A-Z])*[a-z]{0,35}$)|(^[А-Я][а-я]{0,35}(-[А-Я])*[а-я]{0,35}$)|(^[A-Z][a-z]{0,70}$)|(^[А-Я][а-я]{0,70}$)";
    private static final String REGEX_ADDRESS = "(^.{5,70}$)";
    private static final String REGEX_PHONE = "(^[8]-(033|029|044|017)-[1-9][0-9]{2}-[0-9]{2}-[0-9]{2}$)";
    private static final String REGEX_LOGIN = "(^[a-zA-Z0-9_-]{5,12}$)";
    private static final String REGEX_PASSWORD = "(^[a-zA-Z0-9_-]{5,12}$)";

    private Pattern pattern;
    private Matcher matcher;

    @Override
    public boolean isSurnameValid(String surname) {
        if (surname.equals("")) {
            return false;
        }
        pattern = Pattern.compile(REGEX_SURNAME);
        matcher = pattern.matcher(surname);
        return matcher.matches();
    }

    @Override
    public boolean isNameValid(String name) {
        if (name.equals("")) {
            return false;
        }
        pattern = Pattern.compile(REGEX_NAME);
        matcher = pattern.matcher(name);
        return matcher.matches();
    }

    @Override
    public boolean isPatronymicValid(String patronymic) {
        if (patronymic.equals("")) {
            return false;
        }
        pattern = Pattern.compile(REGEX_PATRONYMIC);
        matcher = pattern.matcher(patronymic);
        return matcher.matches();
    }

    @Override
    public boolean isAddressValid(String address) {
        if (address.equals("")) {
            return false;
        }
        pattern = Pattern.compile(REGEX_ADDRESS);
        matcher = pattern.matcher(address);
        return matcher.matches();
    }

    @Override
    public boolean isPhoneValid(String phone) {
        if (phone.equals("")) {
            return false;
        }
        pattern = Pattern.compile(REGEX_PHONE);
        matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    @Override
    public boolean isLoginValid(String login) {
        if (login.equals("")) {
            return false;
        }
        pattern = Pattern.compile(REGEX_LOGIN);
        matcher = pattern.matcher(login);
        return matcher.matches();
    }

    @Override
    public boolean isPasswordValid(String password) {
        if (password.equals("")) {
            return false;
        }
        pattern = Pattern.compile(REGEX_PASSWORD);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}

package by.epam.bakery.service.validator.api;

public interface UserDataValidator {
    boolean isSurnameValid(String surname);
    boolean isNameValid(String name);
    boolean isPatronymicValid(String patronymic);
    boolean isAddressValid(String address);
    boolean isPhoneValid(String phone);
}

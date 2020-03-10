package by.epam.bakery.domain;

public enum RoleEnum {
    ADMIN("admin"),
    COURIER("courier"),
    USER("user");

    private String value;

    RoleEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

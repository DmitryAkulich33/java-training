package by.epam.bakery.domain;

public enum StatusEnum {
    READY("ready"),
    NOTREADY("not ready"),
    DELIVERED("delivered"),
    NOTDELIVERED("not delivered");

    private String value;

    StatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

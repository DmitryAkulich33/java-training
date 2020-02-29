package by.epam.xml.domain;

public enum StatusEnum {
    NOT_READY("not ready"),
    READY("ready"),
    DELIVERED("delivered"),
    UNDELIVERED("undelivered");
    private String value;

    StatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

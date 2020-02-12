package by.epam.bakery.domain;

public class Client extends Entity {
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private String phone;
    private String note;

    public Client() {
    }

    public Client(int id, String surname, String name, String patronymic, String address, String phone, String note) {
        super(id);
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.phone = phone;
        this.note = note;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + surname +
                " " + name +
                " " + patronymic +
                ", address: " + address +
                ", phone: " + phone +
                ", note: '" + note;
    }
}

package by.epam.xml.xmlorders;

public class Client {
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private String address;
    private String phone;
    private String note;

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
        return "(id: " + id +
                ", name: " + name +
                ", surname: " + surname +
                ", patronymic: " + patronymic +
                ", address: " + address +
                ", phone: " + phone +
                ", note: " + note + ")";
    }
}

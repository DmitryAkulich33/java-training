package by.epam.xml.domain;

public class Client {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private String phone;
    private String note;

    public Client() {
    }

    public Client(int id, String surname, String name, String patronymic, String address, String phone, String note) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.phone = phone;
        this.note = note;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != client.id) return false;
        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        if (surname != null ? !surname.equals(client.surname) : client.surname != null) return false;
        if (patronymic != null ? !patronymic.equals(client.patronymic) : client.patronymic != null) return false;
        if (address != null ? !address.equals(client.address) : client.address != null) return false;
        if (phone != null ? !phone.equals(client.phone) : client.phone != null) return false;
        return note != null ? note.equals(client.note) : client.note == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }
}

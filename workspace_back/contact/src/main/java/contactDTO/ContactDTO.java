package contactDTO;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class ContactDTO {
    private int id;
    private String name;
    private String contact;
    private Timestamp birthday;

    public ContactDTO(int id, String name, String contact, Timestamp birthday) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.birthday = birthday;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getBirthday() {
        return birthday.toLocalDateTime().toLocalDate().toString();
    }

    public void setBirthday(String birthday) {
        this.birthday = Timestamp.valueOf(birthday);
    }
}

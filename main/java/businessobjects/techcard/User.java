package businessobjects.techcard;

public class User {
    private int ID;
    private String Name;
    private String LastName;
    private String Birth;
    private String Phone;
    private String Email;
    private String Document;
    private String Password;

    public User() {
    }

    public User(int id, String name, String lastName, String birth, String phone, String email, String document, String password) {
        ID = id;
        Name = name;
        LastName = lastName;
        Birth = birth;
        Phone = phone;
        Email = email;
        Document = document;
        Password = password;
    }


    public User(String name, String lastName, String birth, String phone, String email, String document, String password) {
        Name = name;
        LastName = lastName;
        Birth = birth;
        Phone = phone;
        Email = email;
        Document = document;
        Password = password;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getBirth() {
        return Birth;
    }

    public void setBirth(String birth) {
        Birth = birth;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDocument() {
        return Document;
    }

    public void setDocument(String document) {
        Document = document;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

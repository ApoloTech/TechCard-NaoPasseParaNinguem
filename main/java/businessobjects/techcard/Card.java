package businessobjects.techcard;

public class Card {
    private String Title;
    private String Description;
    private String Phone;
    private String Phone2;
    private String Key;

    public Card() {
    }

    public Card(String title, String description, String phone, String phone2, String key) {
        Title = title;
        Description = description;
        Phone = phone;
        Phone2 = phone2;
        Key = key;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPhone2() {
        return Phone2;
    }

    public void setPhone2(String phone2) {
        Phone2 = phone2;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }
}

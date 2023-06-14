package Participants;

import ma02_resources.participants.Instituition;
import ma02_resources.participants.InstituitionType;
import ma02_resources.participants.Contact;

public class InstituitionImp implements Instituition {
    private final String name;
    private ContactImp contact;
    private final String email;
    private InstituitionType type;
    private String description;
    private String website;

    public InstituitionImp(String name, ContactImp contact, String email, InstituitionType type, String description, String website) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.type = type;
        this.description = description;
        this.website = website;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        InstituitionImp that = (InstituitionImp) obj;

        return email.equals(that.email) && name.equals(that.name) && website.equals(that.website);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public InstituitionType getType() {
                return this.type;
    }

    @Override
    public Contact getContact() {
        return this.contact;
    }

    @Override
    public String getWebsite() {
        return this.website;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setWebsite(String s) {
        this.website = s;
    }

    @Override
    public void setDescription(String s) {
        this.description = s;
    }

    @Override
    public void setContact(Contact contact) {
        this.contact = (ContactImp) contact;
    }

    @Override
    public void setType(InstituitionType instituitionType) {
        this.type = instituitionType;
    }

    @Override
    public String toString() {
        return ("\n -------Institution-------" +
                "\n Name: " + name +
                "\n Contact: " + contact.toString() +
                "\n Email: " + email +
                "\n Type: " + type.toString() +
                "\n Description: " + description +
                "\n Website: " + website) +
                "\n --------------------------";
    }
}

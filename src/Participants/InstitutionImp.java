package Participants;

import ma02_resources.participants.Instituition;
import ma02_resources.participants.InstituitionType;
import ma02_resources.participants.Contact;

import java.util.HashMap;

public class InstitutionImp implements Instituition {
    private final String name;
    private ContactImp contact;
    private final String email;
    private InstituitionType type;
    private final String description;
    private String website;

    public InstitutionImp(String name, ContactImp contact, String email, InstituitionType type, String description, String website) {
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

        InstitutionImp that = (InstitutionImp) obj;

        return email.equals(that.email) && name.equals(that.name) && website.equals(that.website);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public InstituitionType getType() {
        return null;
    }

    @Override
    public Contact getContact() {
        return null;
    }

    @Override
    public String getWebsite() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void setWebsite(String s) {
        this.website = s;
    }

    @Override
    public void setDescription(String s) {

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

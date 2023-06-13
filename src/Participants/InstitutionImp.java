package Participants;


import ma02_resources.participants.Instituition;
import ma02_resources.participants.InstituitionType;

public class InstitutionImp implements Instituition {
    private final String name;
    private final ContactImp contactImp;
    private final String email;
    private final InstituitionType type;
    private final String description;
    private final String website;
    public InstitutionImp(String name, ContactImp contactImp, String email, InstituitionType type, String description, String website) {
        this.name = name;
        this.contactImp = contactImp;
        this.email = email;
        this.type = type;
        this.description = description;
        this.website = website;
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
    public ma02_resources.participants.Contact getContact() {
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

    }

    @Override
    public void setDescription(String s) {

    }

    @Override
    public void setContact(ma02_resources.participants.Contact contact) {

    }

    @Override
    public void setType(InstituitionType instituitionType) {

    }
}

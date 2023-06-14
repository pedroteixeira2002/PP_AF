package Participants;

import ma02_resources.participants.Contact;
import ma02_resources.participants.Participant;
import ma02_resources.participants.Instituition;

abstract class ParticipantImp implements Participant {
    private final String name;
    private final String email;
    private ContactImp contact;
    private InstituitionImp instituition;

    public ParticipantImp(String name, String email, ContactImp contact, InstituitionImp instituition) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.instituition = instituition;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public ContactImp getContact() {
        return contact;
    }

    public InstituitionImp getInstituition() {
        return instituition;
    }

    public void setContact(Contact contact) {
        ContactImp that = (ContactImp) contact;
        this.contact = that;
    }

    public void setInstituition(Instituition instituition) {
        InstituitionImp that = (InstituitionImp) instituition;
        this.instituition = that;
    }

    @Override
    public String toString() {
        return ("\n -------Participant-------" +
                "\n Name: " + name +
                "\n Email: " + email +
                "\n Contact: " + contact.toString() +
                "\n Institution: " + instituition.toString());
    }

}
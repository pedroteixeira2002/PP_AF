package Participants;

import ma02_resources.participants.Contact;
import ma02_resources.participants.Instituition;
import ma02_resources.participants.Student;

public class StudentImp extends ParticipantImp implements Student {
    private final int number;

    public StudentImp(String name, String email, ContactImp contactImp, InstituitionImp instituitionImp, int number) {
        super(name, email, contactImp, instituitionImp);
        this.number = number;
    }

    /**
     * @return number
     */
    @Override
    public int getNumber() {
        return this.number;
    }

    /**
     * @return super.getName()
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * @return super.getEmail()
     */
    @Override
    public String getEmail() {
        return super.getEmail();
    }

    /**
     * @return super.getContact()
     */
    @Override
    public ContactImp getContact() {
        return super.getContact();
    }

    /**
     * @return super.getInstituition()
     */
    @Override
    public InstituitionImp getInstituition() {
        return super.getInstituition();
    }

    /**
     * @param instituition
     */
    @Override
    public void setInstituition(Instituition instituition) {
        super.setInstituition(instituition);
    }

    /**
     * @param contact
     */
    @Override
    public void setContact(Contact contact) {
        super.setContact(contact);
    }

    @Override
    public String toString() {
        return ("\n" + super.toString() +
                "\n -------Student-------" +
                "\n Student Number: " + number);
    }
}

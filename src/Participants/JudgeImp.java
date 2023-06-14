package Participants;

import Interfaces.Judge;
import ma02_resources.participants.Contact;
import ma02_resources.participants.Instituition;

public class JudgeImp extends ParticipantImp implements Judge {
    public JudgeImp(String name, String email, ContactImp contact, InstituitionImp institution) {
        super(name, email, contact, institution);
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
        return null;
    }

    /**
     * @return super.getContact()
     */
    @Override
    public ContactImp getContact() {
        return null;
    }

    /**
     * @return
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

    }

    /**
     * @param instituition
     */
    @Override
    public void setInstituition(InstituitionImp instituition) {
        InstituitionImp that = (InstituitionImp) instituition;
        super.setInstituition(that);
    }

    /**
     * @param contact
     */
    @Override
    public void setContact(Contact contact) {

    }

    @Override
    public String toString() {
        return "\n-------Judge------- "
                + "\n" + super.toString();
    }
}

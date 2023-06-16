package Participants;

import ma02_resources.participants.Contact;
import ma02_resources.participants.Instituition;

public class JudgeImp extends ParticipantImp {
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
        return "\n-------Judge------- "
                + "\n" + super.toString();
    }
}

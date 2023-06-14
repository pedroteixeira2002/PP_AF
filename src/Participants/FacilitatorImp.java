package Participants;

import ma02_resources.participants.Contact;
import ma02_resources.participants.Facilitator;
import ma02_resources.participants.Instituition;

public class FacilitatorImp extends ParticipantImp implements Facilitator {

    private String areaOfExpertise;

    public FacilitatorImp(String name, String email, ContactImp contact, InstituitionImp institution, String areaOfExpertise) {
        super(name, email, contact, institution);
        this.areaOfExpertise = areaOfExpertise;
    }

    /**
     * @return areaOfExpertise
     */
    @Override
    public String getAreaOfExpertise() {
        return this.areaOfExpertise;
    }

    /**
     * @param s
     */
    @Override
    public void setAreaOfExpertise(String s) {
        this.areaOfExpertise = s;
    }

    /**
     * @return
     */
    @Override
    public String getName() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public String getEmail() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public ContactImp getContact() {
        return super.getContact();
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
     * @param contact
     */
    @Override
    public void setContact(Contact contact) {

    }

    @Override
    public String toString() {
        return ("\n " + super.toString() +
                "\n -------Facilitator-------" +
                "\n Area Of Expertise: " + areaOfExpertise);
    }
}

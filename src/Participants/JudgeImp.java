package Participants;
import Interfaces.Judge;
import ma02_resources.participants.Contact;
import ma02_resources.participants.Instituition;

public class JudgeImp extends ParticipantImp implements Judge{
    public JudgeImp(String name, String email, ContactImp contact, InstitutionImp institutionImp) {
        super(name, email, contact, institutionImp);
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
    public Contact getContact() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Instituition getInstituition() {
        return null;
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
}

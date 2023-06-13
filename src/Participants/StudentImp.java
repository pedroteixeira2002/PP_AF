package Participants;
import ma02_resources.participants.Contact;
import ma02_resources.participants.Instituition;
import ma02_resources.participants.Student;

public class StudentImp extends ParticipantImp implements Student{
    private int number;

    public StudentImp(String name, String email, ContactImp contactImp, InstitutionImp institutionImp, int number) {
        super(name, email, contactImp, institutionImp);
        this.number = number;
    }

    public StudentImp(String name, String email, ContactImp contactImp, InstitutionImp institutionImp) {
        super(name, email, contactImp, institutionImp);
    }

    /**
     * @return number
     */
    @Override
    public int getNumber() {
        return this.number;
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

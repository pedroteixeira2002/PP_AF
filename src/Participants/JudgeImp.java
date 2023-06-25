/*
 * Nome: João Pedro Ferreira Teixeira
 * Número: 8200489
 * Turma: LEI12T3
 *
 * Nome: Rómulo César Marinho Leite
 * Número: 8200593
 * Turma: LEI12T2
 */
package Participants;

import ma02_resources.participants.Contact;
import ma02_resources.participants.Instituition;
/**
 * Class that represents a Judge
 * @version 5.6
 */
public class JudgeImp extends ParticipantImp {
    public JudgeImp(String name, String email, ContactImp contact, InstituitionImp institution) {
        super(name, email, contact, institution);
    }

    /**
     * this method returns the name of the judge.
     * @return name of the judge
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * this method returns the email of the judge.
     * @return email of the judge
     */
    @Override
    public String getEmail() {
        return null;
    }

    /**
     * this method returns the contact of the judge.
     * @return contact of the judge
     */
    @Override
    public ContactImp getContact() {
        return null;
    }

    /**
     * this method returns the instituition of the judge.
     * @return instituition of the judge
     */
    @Override
    public InstituitionImp getInstituition() {
        return super.getInstituition();
    }


    /**
     * this method sets the instituition of the judge.
     * @param instituition instituition of the judge
     */
    @Override
    public void setInstituition(Instituition instituition) {
        super.setInstituition(instituition);
    }

    /**
     * this method sets the contact of the judge.
     * @param contact contact of the judge
     */
    @Override
    public void setContact(Contact contact) {
        super.setContact(contact);
    }

    /**
     * this method returns the judge's information.
     * @return judge's information
     */
    @Override
    public String toString() {
        return "\n-------Judge------- "
                + "\n" + super.toString();
    }
}

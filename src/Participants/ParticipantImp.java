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
import ma02_resources.participants.Participant;
import ma02_resources.participants.Instituition;

/**
 * This class implements the Participant interface and defines the methods
 * that will be used by the ParticipantImp objects.
 *
 * @version 1.0
 */
public abstract class ParticipantImp implements Participant {
    private final String name;
    private final String email;
    private Contact contact;
    private Instituition instituition;

    /**
     * This constructor creates a ParticipantImp object with the following parameters.
      * @param name The name of the participant.
     * @param email The email of the participant.
     * @param contact The contact of the participant.
     * @param instituition  The instituition of the participant.
     */
    public ParticipantImp(String name, String email, ContactImp contact, InstituitionImp instituition) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.instituition = instituition;
    }

    /**
     * this method returns the name of the participant.
     * @return The name of the participant.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * this method returns the email of the participant.
     * @return The email of the participant.
     */
    @Override
    public String getEmail() {
        return email;
    }

    /**
     * this method returns the contact of the participant.
     * @return The contact of the participant.
     */
    @Override
    public ContactImp getContact() {
        return contact;
    }

    /**
     * this method returns the instituition of the participant.
     * @return The instituition of the participant.
     */
    public InstituitionImp getInstituition() {
        return instituition;
    }

    /**
     * this method sets the contact of the participant.
     * @param contact   The contact of the participant.
     */
    public void setContact(Contact contact) {
        ContactImp that = (ContactImp) contact;
        this.contact = that;
    }

    /**
     * this method sets the instituition of the participant.
     * @param instituition The instituition of the participant.
     */
    public void setInstituition(Instituition instituition) {
        InstituitionImp that = (InstituitionImp) instituition;
        this.instituition = that;
    }

    /**
     * this method returns the participant information.
     * @return The participant information.
     */
    @Override
    public String toString() {
        return ("\n -------Participant-------" +
                "\n Name: " + name +
                "\n Email: " + email +
                "\n Contact: " + contact.toString() +
                "\n Institution: " + instituition.toString());
    }

}
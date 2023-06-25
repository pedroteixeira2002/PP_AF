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
import ma02_resources.participants.Student;

/**
 * This class represents a Student
 */

public class StudentImp extends ParticipantImp implements Student {
    private final int number;

    public StudentImp(String name, String email, ContactImp contactImp, InstituitionImp instituitionImp, int number) {
        super(name, email, contact, instituition);
        this.number = number;
    }

    /**
     * @return the number of the student
     */
    @Override
    public int getNumber() {
        return this.number;
    }

    /**
     * @return the name of the student
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * @return the email of the student
     */
    @Override
    public String getEmail() {
        return super.getEmail();
    }

    /**
     * @return the contact of the student
     */
    @Override
    public Contact getContact() {
        return super.getContact();
    }

    /**
     * @return the instituition of the student
     */
    @Override
    public Instituition getInstituition() {
        return super.getInstituition();
    }

    /**
     * @param instituition the instituition to set
     */
    @Override
    public void setInstituition(Instituition instituition) {
        super.setInstituition(instituition);
    }

    /**
     * @param contact the contact to set
     */
    @Override
    public void setContact(Contact contact) {
        super.setContact(contact);
    }

    /**
     * toString method
     * @param
     */
    @Override
    public String toString() {
        return ("\n" + super.toString() +
                "\n -------Student-------" +
                "\n Student Number: " + number);
    }
}

/*
 * Nome: João Pedro Ferreira Teixeira
 * Número: 8200489
 * Turma: LEI12T3
 *
 * Nome: Rómulo César Marinho Leite
 * Número: 8200593
 * Turma: LEI12T2
 */

package cbl;

import Interfaces.Event;
import Participants.ParticipantImp;
import enumerations.EventType;
import exceptions.ParticipantNotAllowed;
import ma02_resources.participants.Facilitator;
import ma02_resources.participants.Participant;
import ma02_resources.participants.Partner;

import java.time.LocalDate;

/**
 * This class represents an event
 */
public class EventImp implements Event {
    private int SIZE = 20;
    private static final int FACTOR = 2;
    private final EventType type;
    private String location;
    private LocalDate startDate, endDate;
    private Participant[] participants;
    private int numberOfParticipants;

    /**
     * constructor of the class
     * @param type the type of the event
     * @param location the location of the event
     * @param startDate the start date of the event
     * @param endDate the end date of the event
     * @param participants the participants of the event
     */
    public EventImp(EventType type, String location, LocalDate startDate, LocalDate endDate, Participant[] participants) {
        this.type = type;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.participants = new Participant[SIZE];
    }

    /**
     * this method returns the participants of the event
     * @return the participants of the event
     */
    @Override
    public ParticipantImp[] getParticipants() {
        return (ParticipantImp[]) participants;
    }

    /**
     * this method returns the number of participants of the event
     * @return the number of participants of the event
     */
    @Override
    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    /**
     * this method returns the type of the event
     * @return the type of the event
     */
    @Override
    public EventType getType() {
        return type;
    }

    /**
     * this method returns the location of the event
     * @return the location of the event
     */
    @Override
    public String getLocation() {
        return location;
    }

    /**
     * this method returns the start date of the event
     * @return the start date of the event
     */
    @Override
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * this method returns the end date of the event
     * @return the end date of the event
     */
    @Override
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * this method sets the location of the event
     * @param location the location of the event
     */
    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * this method sets the start date of the event
     * @param startDate the start date of the event
     */
    @Override
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * this method sets the end date of the event
     * @param endDate the end date of the event
     */
    @Override
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * this method adds a participant to the event
     * @param participant the participant to be added
     * @throws ParticipantNotAllowed if the participant is not allowed in the event
     */
    @Override
    public void addParticipantsToEvent(Participant participant) throws ParticipantNotAllowed {
        if (numberOfParticipants == this.participants.length) {
            expandParticipants();
        }

        if (getType() == EventType.KICKOFF && (participant instanceof Partner || participant instanceof Facilitator))
            this.participants[numberOfParticipants] = participant;

        else throw new ParticipantNotAllowed("Participant not allowed in this event");

        if (getType() == EventType.BOOTCAMP && (participant instanceof Facilitator))
            this.participants[numberOfParticipants] = participant;
        else throw new ParticipantNotAllowed("Participant not allowed in this event");

        if (getType() == EventType.PITCH)
            this.participants[numberOfParticipants] = participant;

        numberOfParticipants++;
    }

    /**
     * this method removes a participant from the event
     */
    private void expandParticipants() {

        Participant[] newParticipants = new Participant[participants.length * FACTOR];
        for (int i = 0; i < participants.length; i++) {
            newParticipants[i] = this.participants[i];
        }
        participants = newParticipants;
    }

    /**
     * this method returns the information of the event
     * @return the information of the event
     */
    @Override
    public String toString() {
        return "\n -------Event-------" +
                "\n Type: " + type.toString() +
                "\n Location: " + location +
                "\n Start Date: " + startDate +
                "\n End Date: " + endDate;
    }

}

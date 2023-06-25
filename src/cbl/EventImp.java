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

public class EventImp implements Event {
    private int SIZE = 20;
    private static final int FACTOR = 2;
    private final EventType type;
    private String location;
    private LocalDate startDate, endDate;
    private Participant[] participants;
    private int numberOfParticipants;

    public EventImp(EventType type, String location, LocalDate startDate, LocalDate endDate, Participant[] participants) {
        this.type = type;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.participants = new Participant[SIZE];
    }

    @Override
    public ParticipantImp[] getParticipants() {
        return (ParticipantImp[]) participants;
    }
@Override
    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    @Override
    public EventType getType() {
        return type;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * @param participant
     * @throws ParticipantNotAllowed
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

    private void expandParticipants() {

        Participant[] newParticipants = new Participant[participants.length * FACTOR];
        for (int i = 0; i < participants.length; i++) {
            newParticipants[i] = this.participants[i];
        }
        participants = newParticipants;
    }

    @Override
    public String toString() {
        return "\n -------Event-------" +
                "\n Type: " + type.toString() +
                "\n Location: " + location +
                "\n Start Date: " + startDate +
                "\n End Date: " + endDate;
    }

}

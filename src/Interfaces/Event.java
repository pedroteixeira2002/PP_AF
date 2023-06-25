/*
 * Nome: João Pedro Ferreira Teixeira
 * Número: 8200489
 * Turma: LEI12T3
 *
 * Nome: Rómulo César Marinho Leite
 * Número: 8200593
 * Turma: LEI12T2
 */

package Interfaces;

import Participants.ParticipantImp;
import enumerations.EventType;
import exceptions.ParticipantNotAllowed;
import ma02_resources.participants.Participant;

import java.time.LocalDate;

/**
 * this interface is responsible for enhancing the event
 */
public interface Event {
    int getNumberOfParticipants();

    EventType getType();

    String getLocation();

    ParticipantImp[] getParticipants();

    LocalDate getStartDate();

    LocalDate getEndDate();


    void setLocation(String location);

    void setStartDate(LocalDate startDate);

    void setEndDate(LocalDate endDate);

    void addParticipantsToEvent(Participant participant) throws ParticipantNotAllowed;
}

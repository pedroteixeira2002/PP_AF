package Interfaces;

import enumerations.EventType;
import exceptions.ParticipantNotAllowed;
import ma02_resources.participants.Participant;

import java.time.LocalDate;

public interface Event {
    int getNumberOfParticipants();

    EventType getType();

    String getLocation();

    Participant[] getParticipants();

    LocalDate getStartDate();

    LocalDate getEndDate();


    void setLocation(String location);

    void setStartDate(LocalDate startDate);

    void setEndDate(LocalDate endDate);

    void addParticipantsToEvent(Participant participant) throws ParticipantNotAllowed;

}

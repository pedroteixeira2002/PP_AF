package Interfaces;

import exceptions.EditionNotActive;
import exceptions.EventAlreadyStarted;
import exceptions.IllegalDate;
import exceptions.ParticipantNotAllowed;
import ma02_resources.participants.Participant;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;

import java.time.LocalDate;

public interface EventController {
     void addEvent(Event event) throws IllegalDate, EditionNotActive;
     boolean removeEvent(Event event) throws EventAlreadyStarted;
     Event updateEvent(Event event, String location, LocalDate startDate, LocalDate endDate) throws EventAlreadyStarted;
     void listEvent();
}

package Interfaces;

import exceptions.EditionNotActive;
import exceptions.EventAlreadyStarted;
import exceptions.IllegalDate;

import java.time.LocalDate;

public interface EventController {
     int getNumberOfEvents();
     Event[] getEvents();
     void addEvent(Event event) throws IllegalDate, EditionNotActive;
     boolean removeEvent(Event event) throws EventAlreadyStarted;
     Event updateEvent(Event event, String location, LocalDate startDate, LocalDate endDate) throws EventAlreadyStarted;
     void listEvent();
}

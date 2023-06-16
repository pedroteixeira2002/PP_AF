package Interfaces;

import ma02_resources.project.Edition;

import java.time.LocalDate;

public interface EventController extends Edition {
     void addEvent(Event event);
     boolean removeEvent(Event event);
     Event updateEvent(Event event, String location, LocalDate startDate, LocalDate endDate);
     Edition listEvent();
}

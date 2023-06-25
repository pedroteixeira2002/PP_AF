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

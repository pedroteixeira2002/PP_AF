/*
 * Nome: João Pedro Ferreira Teixeira
 * Número: 8200489
 * Turma: LEI12T3
 *
 * Nome: Rómulo César Marinho Leite
 * Número: 8200593
 * Turma: LEI12T2
 */

package exceptions;

/**
 * this exception is thrown when a event is already started
 */
public class EventAlreadyStarted extends Exception{
    public EventAlreadyStarted(String message) {
        super(message);
    }
}

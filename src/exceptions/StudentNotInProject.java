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
 * this exception is thrown when a student is not in the project
 */
public class StudentNotInProject extends Exception{
    public StudentNotInProject(String message) {
        super(message);
    }
}

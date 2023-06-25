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
 * this exception is thrown when a tag is already in the project
 */
public class TagAlreadyInProject extends Exception {
    public TagAlreadyInProject(String message) {
        super(message);
    }
}

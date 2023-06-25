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

import ma02_resources.participants.Student;
import ma02_resources.project.Submission;

/**
 * this interface is responsible for enhancing the task
 */
public interface TaskEnhanced {

    void addSubmission(Submission submission, Student student) throws IllegalArgumentException;
}

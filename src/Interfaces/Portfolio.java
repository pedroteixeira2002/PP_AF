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

import cbl.EditionImp;
import exceptions.SubmissionsUpToDate;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;

/**
 * this interface is responsible for enhancing the portfolio
 */
public interface Portfolio {
    int getNumberOfEditions();

    Edition allMissingSubmissions() throws SubmissionsUpToDate;

    Project missingSubmissions(Edition edition) throws SubmissionsUpToDate;

    void hasEdition(Edition edition) throws IllegalArgumentException;
    public Edition getEdition(String name);

}

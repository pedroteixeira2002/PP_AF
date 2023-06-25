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
import ma02_resources.project.Edition;

/**
 * this interface is responsible for enhancing the editions controller
 */
public interface EditionsController {
    Edition[] getEditions();

    boolean removeEdition(String editionName);

    Edition getEdition(Edition edition);

    void addEdition(Edition edition) throws IllegalArgumentException;

}

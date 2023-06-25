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

import Participants.ParticipantImp;
import ma02_resources.project.Project;

/**
 * this interface is responsible for enhancing the project
 */
public interface ProjectEnhanced extends Project{

    void removeTag(String tag);

    ParticipantImp[] getParticipants();
}

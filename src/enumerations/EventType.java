/*
 * Nome: João Pedro Ferreira Teixeira
 * Número: 8200489
 * Turma: LEI12T3
 *
 * Nome: Rómulo César Marinho Leite
 * Número: 8200593
 * Turma: LEI12T2
 */

package enumerations;

public enum EventType {
    KICKOFF,
    PITCH,
    BOOTCAMP;

    private EventType() {
    }
public String toString() {
        switch(this) {
            case KICKOFF:
                return "Kickoff Meeting";
            case PITCH:
                return "Pitch";
            case BOOTCAMP:
                return "Bootcamp";
            default:
                return "Invalid";
        }
    }

}


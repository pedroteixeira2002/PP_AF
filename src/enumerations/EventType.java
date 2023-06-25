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

/**
 * this enumeration represents the type of event
 */
public enum EventType {
    KICKOFF,
    PITCH,
    BOOTCAMP;

    private EventType() {
    }

    /**
     * this method returns the event type in a string format
     * @return the event type in a string format
     */
    public String toString() {
        switch (this) {
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


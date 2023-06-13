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


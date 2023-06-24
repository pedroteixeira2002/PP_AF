package cbl;

import ma02_resources.participants.Instituition;
import ma02_resources.participants.Participant;
import ma02_resources.project.Edition;

public class Manager {

    private final int FACTOR = 2;

    private static int EditionsSize = 2;
    private int participantsSize = 5;
    private int instituitionSize = 5;

    private int numberOfEditions;
    private int numberOfParticipants;
    private int numberOfInstituitions;


    private Edition[] editions;
    private Participant[] participants;
    private Instituition[] instituitions;


    public Manager() {
        this.numberOfEditions = 0;
        this.numberOfParticipants = 0;
        this.numberOfInstituitions = 0;
        this.editions = new Edition[EditionsSize];
        this.participants = new Participant[participantsSize];
        this.instituitions = new Instituition[instituitionSize];
    }


    public Participant getParticipant(String email) {
        for (int i = 0; i < numberOfParticipants; i++) {
            if (participants[i].getEmail().equals(email)) {
                return participants[i];
            }
        }
        throw new NullPointerException("That email does not exist");
    }

}

package Participants;

import ma02_resources.participants.Participant;

import java.util.Arrays;

abstract class ParticipantImp implements Participant {
    private final static int MAX_INSTITUTIONS = 10;
    private final String name;
    private final String email;
    private final ContactImp contact;
    private final InstitutionImp[] institution;

    public ParticipantImp(String name, String email, ContactImp contact, InstitutionImp institutionImp) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.institution = new InstitutionImp[MAX_INSTITUTIONS];
    }

    @Override
    public String toString() {
        return ("\n -------Participant-------" +
                "\n Name: " + name +
                "\n Email: " + email +
                "\n Contact: " + contact.toString() +
                "\n Institution: " + Arrays.toString(Arrays.stream(institution).toArray()));
    }
}
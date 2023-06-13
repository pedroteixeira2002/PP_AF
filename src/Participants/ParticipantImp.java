package Participants;

import ma02_resources.participants.Participant;

abstract class ParticipantImp implements Participant {
    private final String name;
    private final String email;
    private final ContactImp contactImp;
    private final InstitutionImp institutionImp;

    public ParticipantImp(String name, String email, ContactImp contactImp, InstitutionImp institutionImp) {
        this.name = name;
        this.email = email;
        this.contactImp = contactImp;
        this.institutionImp = institutionImp;
    }

}

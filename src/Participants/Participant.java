package Participants;

abstract class Participant {
    private final String name;
    private final String email;
    private final Contact contact;
    private final Institution institution;

    public Participant(String name, String email, Contact contact, Institution institution) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.institution = institution;
    }

}

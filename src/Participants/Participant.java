package Participants;

abstract class Participant {
    private String name;
    private String email;
    private Contact contact;
    private Institution institution;

    public Participant(String name, String email, Contact contact, Institution institution) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.institution = institution;
    }

}

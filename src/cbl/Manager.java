package cbl;

import Participants.PartnerImp;
import Participants.StudentImp;
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

    public void addParticipant(Participant p) {
        expandParticipants();
        this.participants[numberOfParticipants++] = p;
    }

    public void expandParticipants(){
        Participant[] tempList = new Participant[this.participants.length * FACTOR];
        for (int i = 0; i < this.participants.length; i++) {
            tempList[i] = this.participants[i];
        }
        this.participants = tempList;
        this.participantsSize *= FACTOR;
    }

    public void listParticipants() {
        for (int i = 0; i < numberOfParticipants; i++) {
            System.out.println(participants[i].toString());
        }
        System.out.println(this.numberOfParticipants + "/" + this.participants.length);
    }

    public void addEdition (Edition ed){
        expandEditions();

        try{
            existEdition(ed.getName());
            this.editions[numberOfEditions++] = ed;
        } catch (IllegalArgumentException exception){
            System.out.println("Edition already exists");
        }
    }

    private int findEdition(String edName){
        for (int i = 0; i < numberOfEditions; i++) {
            if (editions[i].getName().equals(edName)){
                return i;
            }
        }
        throw new IllegalArgumentException("Edition not found");
    }

    public void removeEdition(String edName){

        int index = findEdition(edName);

        for (int i = index; i < numberOfEditions - 1; i++) {
            editions[i] = editions[i + 1];
        }
        editions[numberOfEditions] = null;
    }

    private void expandEditions(){
        Edition[] tempList = new Edition[this.editions.length * FACTOR];
        if (numberOfEditions == this.editions.length){
            for (int i = 0; i < this.editions.length; i++) {
                tempList[i] = this.editions[i];
            }
            this.editions = tempList;
        }
    }

    private void existEdition(String name) {
        for (int i = 0; i < numberOfEditions; i++) {
            if (editions[i].getName().equals(name)) {
                throw new IllegalArgumentException("Edition already exists");
            }
        }
    }
}

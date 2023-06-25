package cbl;

import Participants.PartnerImp;
import Participants.StudentImp;
import ma02_resources.participants.Instituition;
import ma02_resources.participants.Participant;
import ma02_resources.project.Edition;
import ma02_resources.project.Status;

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

    public void listEditions(){
        for (int i = 0; i < numberOfEditions; i++) {
            System.out.println(editions[i].toString());
        }
        System.out.println(this.numberOfEditions + "/" + this.editions.length);
    }

    public void setStatusActive (Edition ed){

        try {
            int index = findEdition(ed.getName());

        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        for (int i=0;i<numberOfEditions;i++){
            if (editions[i].equals(ed)){
                editions[i].setStatus(Status.ACTIVE);
            } else {
                editions[i].setStatus(Status.INACTIVE);
            }
        }
    }

    public String checkEditionProgress (Edition edition){
        int count = 0;
        String temp = "";
        String progress = "";
        for (int i=0;i<edition.getNumberOfProjects();i++){
            if (edition.getProjects()[i].isCompleted()){
                temp += edition.getProjects()[i].toString() + "\n";
                count++;
            }
        }
        progress = "Progres= " + count + "/" + edition.getNumberOfProjects() + "Projects completed: \n" + temp;
        return progress;
    }

    public Edition getEdition(String edName){
        return this.editions[findEdition(edName)];
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

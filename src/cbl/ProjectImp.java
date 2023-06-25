/*
 * Nome: João Pedro Ferreira Teixeira
 * Número: 8200489
 * Turma: LEI12T3
 *
 * Nome: Rómulo César Marinho Leite
 * Número: 8200593
 * Turma: LEI12T2
 */

package cbl;

import Interfaces.ProjectEnhanced;
import Participants.ParticipantImp;
import exceptions.*;
import ma02_resources.participants.*;
import ma02_resources.project.Project;
import ma02_resources.project.Task;
import ma02_resources.project.exceptions.*;

import java.util.Arrays;

/**
 * this class represents a project
 */
public class ProjectImp implements ProjectEnhanced {
    private static int SIZE = 50;
    private final int FACTOR = 2;
    private final String name;
    private final String description;
    private int numberOfParticipants;
    private int numberOfStudents;
    private int numberOfPartners;
    private int numberOfFacilitators;
    private int numberOfTasks;
    private int numberOfTags;
    private final int maximumNumberOfTags;
    private final int maximumNumberOfTasks;
    private final long maximumNumberOfParticipants;
    private final int maximumNumberOfStudents;
    private final int maximumNumberOfPartners;
    private final int maximumNumberOfFacilitators;
    private int rank = 0;
    private Participant[] participants;
    private Task[] tasks;
    private String[] tags;

    /**
     * constructor of the class
     *
     * @param name                        the name of the project
     * @param description                 the description of the project
     * @param tags                        the tags of the project
     * @param maximumNumberOfStudents     the maximum number of students
     * @param maximumNumberOfPartners     the maximum number of partners
     * @param maximumNumberOfFacilitators the maximum number of facilitators
     */
    public ProjectImp(String name, String description, String[] tags, int maximumNumberOfStudents,
                      int maximumNumberOfPartners, int maximumNumberOfFacilitators) {
        this.name = name;
        this.description = description;
        this.maximumNumberOfTasks = 0;
        this.maximumNumberOfTags = tags.length + 1;
        this.maximumNumberOfParticipants = maximumNumberOfStudents + maximumNumberOfPartners + maximumNumberOfFacilitators;
        this.maximumNumberOfStudents = maximumNumberOfStudents;
        this.maximumNumberOfPartners = maximumNumberOfPartners;
        this.maximumNumberOfFacilitators = maximumNumberOfFacilitators;
        this.rank = 0;
        this.participants = new Participant[SIZE];
        this.tasks = new Task[SIZE];
        this.tags = tags;
    }

    /**
     * constructor of the class
     *
     * @param name                        the name of the project
     * @param description                 the description of the project
     * @param maximumNumberOfStudents     the maximum number of students
     * @param maximumNumberOfPartners     the maximum number of partners
     * @param maximumNumberOfFacilitators the maximum number of facilitators
     * @param rank                        the rank of the project
     * @param participants                the participants of the project
     * @param tasks                       the tasks of the project
     * @param tags                        the tags of the project
     */
    public ProjectImp(String name, String description, int maximumNumberOfStudents, int maximumNumberOfPartners, int maximumNumberOfFacilitators, int rank, Participant[] participants, Task[] tasks, String[] tags) {
        this.name = name;
        this.description = description;
        this.maximumNumberOfParticipants = maximumNumberOfStudents + maximumNumberOfPartners + maximumNumberOfFacilitators;
        this.maximumNumberOfStudents = maximumNumberOfStudents;
        this.maximumNumberOfPartners = maximumNumberOfPartners;
        this.maximumNumberOfFacilitators = maximumNumberOfFacilitators;
        this.maximumNumberOfTags = tags.length + 1;
        this.maximumNumberOfTasks = tasks.length + 1;
        this.rank = rank;
        this.participants = participants;
        this.tasks = tasks;
        this.tags = tags;
    }

    /**
     * constructor of the class
     */
    public ProjectImp() {
        this.name = null;
        this.description = null;
        this.maximumNumberOfParticipants = 0;
        this.maximumNumberOfStudents = 0;
        this.maximumNumberOfPartners = 0;
        this.maximumNumberOfFacilitators = 0;
        this.maximumNumberOfTags = 0;
        this.maximumNumberOfTasks = 0;
        this.rank = 0;
        this.participants = null;
        this.tasks = null;
        this.tags = null;
    }

    /**
     * this method gets the name of the project
     * @return the name of the project
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * this method gets the description of the project
     * @return the description of the project
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * this method get the number of participants of the project
     * @return the number of participants of the project
     */
    @Override
    public int getNumberOfParticipants() {
        return this.numberOfParticipants;
    }

    /**
     * this method gets the number of students of the project
     * @return the number of students of the project
     */
    @Override
    public int getNumberOfStudents() {
        return this.numberOfStudents;
    }

    /**
     * this method gets the number of partners of the project
     * @return the number of partners of the project
     */
    @Override
    public int getNumberOfPartners() {
        return this.numberOfPartners;
    }

    /**
     * this method gets the number of facilitators of the project
     * @return the number of facilitators of the project
     */
    @Override
    public int getNumberOfFacilitators() {
        return this.numberOfFacilitators;
    }

    /**
     * this method gets the number of tasks of the project
     * @return true if the participant was added, false otherwise
     */
    @Override
    public int getNumberOfTasks() {
        return this.numberOfTasks;
    }

    /**
     * this method gets the number of tags of the project
     * @return the number of tags of the project
     */
    @Override
    public int getMaximumNumberOfTasks() {
        return this.maximumNumberOfTasks;
    }

    /**
     * this method gets the maximum number of participants of the project
     * @return the number of participants of the project
     */
    @Override
    public long getMaximumNumberOfParticipants() {
        return this.maximumNumberOfParticipants;
    }

    /**
     * this method gets the maximum number of tags of the project
     * @return the number of students of the project
     */
    @Override
    public int getMaximumNumberOfStudents() {
        return this.maximumNumberOfStudents;
    }

    /**
     * this method gets the maximum number of partners of the project
     * @return the number of partners of the project
     */
    @Override
    public int getMaximumNumberOfPartners() {
        return this.maximumNumberOfPartners;
    }

    /**
     * this method gets the maximum number of facilitators of the project
     * @return the number of facilitators of the project
     */
    @Override
    public int getMaximumNumberOfFacilitators() {
        return this.maximumNumberOfFacilitators;
    }

    /**
     * this method gets the index of the participant
     * @param participant the participant
     * @return the index of the participant
     */
    public int getIndex(Participant participant) {
        for (int i = 0; i < participants.length; i++) {
            if (participants[i] == participant)
                return i;
        }
        return -1;
    }

    /**
     * this method gets the tasks of the project
     * @param s the title of the task
     * @return the task
     */
    @Override
    public Task getTask(String s) {
        for (Task task : this.tasks) {
            if (task.getTitle().equals(s)) {
                return task;
            }
        }
        return null;
    }

    /**
     * this method gets the tasks of the project
     * @return the tasks of the project
     */
    @Override
    public Task[] getTasks() {
        return this.tasks;
    }


    /**
     * this method gets the participants of the project by email
     * @param email the email of the participant
     * @return the participant
     * @throws NullPointerException if the participant is not found
     */
    @Override
    public Participant getParticipant(String email) throws NullPointerException {
        for (int i = 0; i < participants.length; i++) {
            if (participants[i].getEmail().equals(email)) {
                return participants[i];
            }
        }
        throw new NullPointerException("Participant not found");
    }

    /**
     * this method expands the participants array
     */
    private void expandParticipants() {

        Participant[] newParticipants = new Participant[participants.length * FACTOR];
        for (int i = 0; i < participants.length; i++) {
            newParticipants[i] = this.participants[i];
        }
        participants = newParticipants;
    }

    /**
     * this method checks if the participant is already in the project
     * @param participant the participant
     * @throws ParticipantAlreadyInProject if the participant is already in the project
     */
    private void hasParticipant(Participant participant) throws ParticipantAlreadyInProject {
        if (participant == null) {
            throw new IllegalArgumentException("Participant cannot be null");
        }

        for (int i = 0; i < participants.length; i++) {
            if (participants[i] == participant) {
                throw new ParticipantAlreadyInProject("Participant already in project");
            }
        }
    }

    /**
     * this method adds a participant to the project
     * @param participant the participant
     * @throws IllegalNumberOfParticipantType if the number of participants is reached
     * @throws ParticipantAlreadyInProject if the participant is already in the project
     */
    @Override
    public void addParticipant(Participant participant) throws IllegalNumberOfParticipantType, ParticipantAlreadyInProject {

        if (participant == null) {
            throw new IllegalArgumentException("Participant Invalid");
        }
        try {
            hasParticipant(participant);
        } catch (ParticipantAlreadyInProject exception) {
            System.out.println(exception.getMessage());
        }

        if (numberOfParticipants == maximumNumberOfParticipants) {
            throw new IllegalNumberOfParticipantType("Maximum number of participants reached");
        }

        if (numberOfStudents == maximumNumberOfStudents) {
            throw new IllegalNumberOfParticipantType("Maximum number of students reached");
        }
        if (numberOfPartners == maximumNumberOfPartners) {
            throw new IllegalNumberOfParticipantType("Maximum number of partners reached");
        }
        if (numberOfFacilitators == maximumNumberOfFacilitators) {
            throw new IllegalNumberOfParticipantType("Maximum number of facilitators reached");
        }
        if (numberOfParticipants == this.participants.length) {
            expandParticipants();
        }
        this.participants[numberOfParticipants] = participant;

        this.numberOfParticipants++;
        if (participant instanceof Student) {
            this.numberOfStudents++;
        } else if (participant instanceof Partner) {
            this.numberOfPartners++;
        } else if (participant instanceof Facilitator) {
            this.numberOfFacilitators++;
        }
        this.numberOfParticipants++;
    }

    /**
     * this method gets the participants of the project
     * @return the participants of the project
     */
    public ParticipantImp[] getParticipants() {
        return (ParticipantImp[]) participants;
    }

    /**
     * this method removes a participant from the project
     * @param s the email of the participant
     * @return the participant
     */
    public Participant removeParticipant(String s) {
        Participant that = getParticipant(s);
        int index = getIndex(that);
        if (index == -1)
            throw new IllegalArgumentException("Participant not found");

        participants[index] = null;
        for (int i = index; i < numberOfParticipants - 1; i++) {
            participants[i] = participants[i + 1];
        }
        this.numberOfParticipants--;

        if (that instanceof Student) {
            this.numberOfStudents--;
        } else if (that instanceof Partner) {
            this.numberOfPartners--;
        } else if (that instanceof Facilitator) {
            this.numberOfFacilitators--;
        }
        return that;
    }

    /**
     * this method list the participants of the project
     */
    public void listParticipants() {
        for (int i = 0; i < numberOfParticipants; i++) {
            System.out.println(participants[i].toString());
        }
        System.out.println(numberOfParticipants + "/" + participants.length);
    }

    /**
     * this method add a tag to the project
     * @param newTag the tag
     * @throws IllegalArgumentException if the tag doesn't exists
     */
    public void addTag(String newTag) throws IllegalArgumentException {
        if (findTag(newTag) == -1) {
            throw new IllegalArgumentException("Tag doesn't exists");
        }
        try {
            if (hasTag(newTag) == true) {
                throw new TagAlreadyInProject("Tag already in project");
            }
        } catch (TagAlreadyInProject e) {
            System.out.println(e.getMessage());
        }

        this.tags[this.numberOfTags] = newTag;
        this.numberOfTags++;

        if (this.numberOfTags == this.maximumNumberOfTags) {
            expandTags();
        }
    }

    /**
     * this method find a tag in the project
     * @param tag the tag to find
     * @return  the tag
     */
    private int findTag(String tag) {
        for (int i = 0; i < this.numberOfTags; i++) {
            if (this.tags[i].equals(tag)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * this method removes a tag from the project
     * @param tag the tag
     */
    public void removeTag(String tag) {
        int index = findTag(tag);

        for (int i = index; i < this.numberOfTags - 1; i++) {
            this.tags[i] = this.tags[i + 1];
        }
        this.numberOfTags--;
    }

    /**
     * this method expand the tags
     */
    private void expandTags() {
        String[] temp = new String[this.tags.length * FACTOR];

        for (int i = 0; i < numberOfTags; i++) {
            temp[i] = this.tags[i];
        }
        this.tags = temp;
    }

    /**
     * this method gets the tags of the project
     * @return the tags of the project
     */
    @Override
    public String[] getTags() {
        return this.tags;
    }

    /**
     * this method checks if the project has a tag
     * @param s the tag
     * @return true if the project has the tag, false otherwise
     */
    @Override
    public boolean hasTag(String s) {
        for (int i = 0; i < this.tags.length; i++) {
            if (this.tags[i].equals(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * this method gets the number of tags of the project
     * @return the number of tags of the project
     */
    @Override
    public void addTask(Task task) throws IllegalNumberOfTasks {

        if (numberOfTasks == maximumNumberOfTasks) {
            throw new IllegalNumberOfTasks("Maximum number of tasks reached");
        }

        try {
            hasTask(task);
        } catch (TaskAlreadyInProject e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        this.tasks[this.numberOfTasks++] = task;
    }

    /**
     * this method checks the tasks of the project
     * @return the tasks of the project
     */
    private void hasTask(Task task) throws TaskAlreadyInProject, IllegalArgumentException {
        if (task == null) {
            throw new IllegalArgumentException("Task don't exists");
        }
        for (int i = 0; i < numberOfTasks; i++) {
            if (this.tasks[i].equals(task)) {
                throw new TaskAlreadyInProject("Task already in project");
            }
        }
    }

    /**
     * this method check if the task is completed
     * @return true if the task is completed, false otherwise
     */
    @Override
    public boolean isCompleted() {
        for (Task task : this.tasks) {
            if (task.getNumberOfSubmissions() == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * this method gets the progress of the project
     * @return the progress of the project
     */
    public String getProgress() {
        int completedTasks = 0;
        for (int i = 0; i < numberOfTasks; i++) {
            if (tasks[i].getNumberOfSubmissions() != 0) {
                completedTasks++;
            }
        }
        return ("\nCompleted: " + completedTasks +
                "\nTotal Tasks: " + numberOfTasks +
                "\nThe project is: " + (completedTasks * 100) / numberOfTasks + "% completed");
    }

    /**
     * this method return the information of the project
     * @return the tasks of the project
     */
    @Override
    public String toString() {
        return "\n Project:" +
                "\n Name:" + name +
                "\n Description=: " + description + '\'' +
                "\n Participants: " + numberOfParticipants + "\t Max. Participants: " + maximumNumberOfParticipants +
                "\n Students: " + numberOfStudents + "\t Max. Students: " + maximumNumberOfStudents +
                "\n Partners: " + numberOfPartners + "\t Max. Partners: " + maximumNumberOfPartners +
                "\n Facilitators: " + numberOfFacilitators + "\t Max. Facilitators: " + maximumNumberOfFacilitators +
                "\n Tasks: " + numberOfTasks + "\t Max. Tasks: " + maximumNumberOfTasks +
                "\n Tags: " + numberOfTags + "\t Max. Tags: " + maximumNumberOfTags +
                "\n Rank: " + rank +
                "\n Participants: " + Arrays.toString(participants) +
                "\n Tasks: " + Arrays.toString(tasks) +
                "\n Tags: " + Arrays.toString(tags);
    }
}
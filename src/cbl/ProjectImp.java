package cbl;

import Interfaces.ProjectEnhanced;
import Participants.ParticipantImp;
import exceptions.*;
import ma02_resources.participants.*;
import ma02_resources.project.Project;
import ma02_resources.project.Task;
import ma02_resources.project.exceptions.*;

import java.util.Arrays;

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

    public ProjectImp(String name, String description, String[] tags, int maximumNumberOfStudents,
                      int maximumNumberOfPartners, int maximumNumberOfFacilitators) {
        this.name = name;
        this.description = description;
        this.maximumNumberOfTasks = 0;
        this.maximumNumberOfTags = 0;
        this.maximumNumberOfParticipants = maximumNumberOfStudents + maximumNumberOfPartners + maximumNumberOfFacilitators;
        this.maximumNumberOfStudents = maximumNumberOfStudents;
        this.maximumNumberOfPartners = maximumNumberOfPartners;
        this.maximumNumberOfFacilitators = maximumNumberOfFacilitators;
        if (this.rank < 0 || this.rank > 10) {
            throw new IllegalArgumentException("Rank must be between 0 and 10");
        } else this.rank = rank;
        this.participants = new Participant[SIZE];
        this.tasks = new Task[SIZE];
        this.tags = new String[FACTOR];

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public int getNumberOfParticipants() {
        return this.numberOfParticipants;
    }

    @Override
    public int getNumberOfStudents() {
        return this.numberOfStudents;
    }

    @Override
    public int getNumberOfPartners() {
        return this.numberOfPartners;
    }

    @Override
    public int getNumberOfFacilitators() {
        return this.numberOfFacilitators;
    }

    @Override
    public int getNumberOfTasks() {
        return this.numberOfTasks;
    }

    @Override
    public int getMaximumNumberOfTasks() {
        return this.maximumNumberOfTasks;
    }

    @Override
    public long getMaximumNumberOfParticipants() {
        return this.maximumNumberOfParticipants;
    }

    @Override
    public int getMaximumNumberOfStudents() {
        return this.maximumNumberOfStudents;
    }

    @Override
    public int getMaximumNumberOfPartners() {
        return this.maximumNumberOfPartners;
    }

    @Override
    public int getMaximumNumberOfFacilitators() {
        return this.maximumNumberOfFacilitators;
    }

    public int getIndex(Participant participant) {
        for (int i = 0; i < participants.length; i++) {
            if (participants[i] == participant)
                return i;
        }
        return -1;
    }

    @Override
    public Task getTask(String s) {
        for (Task task : this.tasks) {
            if (task.getTitle().equals(s)) {
                return task;
            }
        }
        return null;
    }

    @Override
    public Task[] getTasks() {
        return this.tasks;
    }


    @Override
    public Participant getParticipant(String email) throws NullPointerException {
        for (int i = 0; i < participants.length; i++) {
            if (participants[i].getEmail().equals(email)) {
                return participants[i];
            }
        }
        throw new NullPointerException("Participant not found");
    }

    public Participant getByEmail(String email) throws IllegalArgumentException {
        for (int i = 0; i < participants.length; i++) {
            if (participants[i].getEmail().equals(email)) {
                return participants[i];
            }
        }
        throw new IllegalArgumentException("Participant not found");
    }

    private void expandParticipants() {

        Participant[] newParticipants = new Participant[participants.length * FACTOR];
        for (int i = 0; i < participants.length; i++) {
            newParticipants[i] = this.participants[i];
        }
        participants = newParticipants;
    }

    private void hasParticipant(Participant participant) throws ParticipantAlreadyInProject {
        for (int i = 0; i < participants.length; i++) {
            if (participants[i] == participant) {
                throw new ParticipantAlreadyInProject("Participant already in project");
            }
        }
    }

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

    public ParticipantImp[] getParticipants() {
        return (ParticipantImp[]) participants;
    }

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

    private int findTag(String tag) {
        for (int i = 0; i < this.numberOfTags; i++) {
            if (this.tags[i].equals(tag)) {
                return i;
            }
        }
        return -1;
    }

    public void removeTag(String tag) {
        int index = findTag(tag);

        for (int i = index; i < this.numberOfTags - 1; i++) {
            this.tags[i] = this.tags[i + 1];
        }
        this.numberOfTags--;
    }

    private void expandTags() {
        String[] temp = new String[this.tags.length * FACTOR];

        for (int i = 0; i < numberOfTags; i++) {
            temp[i] = this.tags[i];
        }
        this.tags = temp;
    }

    @Override
    public String[] getTags() {
        return this.tags;
    }

    @Override
    public boolean hasTag(String s) {
        for (int i = 0; i < this.tags.length; i++) {
            if (this.tags[i].equals(s)) {
                return true;
            }
        }
        return false;
    }

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

    @Override
    public boolean isCompleted() {
        for (Task task : this.tasks) {
            if (task.getNumberOfSubmissions() == 0) {
                return false;
            }
        }
        return true;
    }


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
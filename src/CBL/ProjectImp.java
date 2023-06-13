package CBL;

import ma02_resources.participants.Participant;
import ma02_resources.project.Project;
import ma02_resources.project.Task;
import ma02_resources.project.exceptions.IllegalNumberOfParticipantType;
import ma02_resources.project.exceptions.IllegalNumberOfTasks;
import ma02_resources.project.exceptions.ParticipantAlreadyInProject;
import ma02_resources.project.exceptions.TaskAlreadyInProject;

public class ProjectImp implements Project {

    private static int SIZE = 50;
    private final int TAGS_FACTOR= 2;
    private String name;
    private String description;
    private int numberOfParticipants;
    private int numberOfStudents;
    private int numberOfPartners;
    private int numberOfFacilitators;
    private int numberOfTasks;

    private int maximumNumberOfTags;
    private int maximumNumberOfTasks;
    private long maximumNumberOfParticipants;
    private int maximumNumberOfStudents;
    private int maximumNumberOfPartners;
    private int maximumNumberOfFacilitators;
    private Participant[] participants;
    private Task[] tasks;
    private String[] tags;

    public ProjectImp(String name, String description, int numberOfParticipants, int numberOfStudents, int numberOfPartners, int numberOfFacilitators, int numberOfTasks, int maximumNumberOfTags, int maximumNumberOfTasks, long maximumNumberOfParticipants, int maximumNumberOfStudents, int maximumNumberOfPartners, int maximumNumberOfFacilitators, Participant[] participants, Task[] tasks, String[] tags) {
        this.name = name;
        this.description = description;
        this.numberOfParticipants = numberOfParticipants;
        this.numberOfStudents = numberOfStudents;
        this.numberOfPartners = numberOfPartners;
        this.numberOfFacilitators = numberOfFacilitators;
        this.numberOfTasks = numberOfTasks;
        this.maximumNumberOfTags = maximumNumberOfTags;
        this.maximumNumberOfTasks = maximumNumberOfTasks;
        this.maximumNumberOfParticipants = maximumNumberOfParticipants;
        this.maximumNumberOfStudents = maximumNumberOfStudents;
        this.maximumNumberOfPartners = maximumNumberOfPartners;
        this.maximumNumberOfFacilitators = maximumNumberOfFacilitators;
        this.participants = participants;
        this.tasks = tasks;
        this.tags = tags;
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

    @Override
    public void addParticipant(Participant participant) throws IllegalNumberOfParticipantType, ParticipantAlreadyInProject {

    }

    @Override
    public Participant removeParticipant(String s) {
        return null;
    }

    @Override
    public Participant getParticipant(String email) {
        return null;
    }

    @Override
    public String[] getTags() {
        return new String[0];
    }

    @Override
    public boolean hasTag(String s) {
        return false;
    }

    @Override
    public void addTask(Task task) throws IllegalNumberOfTasks, TaskAlreadyInProject {

    }

    @Override
    public Task getTask(String s) {
        return null;
    }

    @Override
    public Task[] getTasks() {
        return new Task[0];
    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}

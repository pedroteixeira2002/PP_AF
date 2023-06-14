package CBL;

import ma02_resources.participants.Participant;
import ma02_resources.project.Project;
import ma02_resources.project.Submission;
import ma02_resources.project.Task;
import ma02_resources.project.exceptions.IllegalNumberOfParticipantType;
import ma02_resources.project.exceptions.IllegalNumberOfTasks;
import ma02_resources.project.exceptions.ParticipantAlreadyInProject;
import ma02_resources.project.exceptions.TaskAlreadyInProject;

public class ProjectImp implements Project {

    private static int SIZE = 50;
    private final int FACTOR = 2;
    private String name;
    private String description;
    private int numberOfParticipants;
    private int numberOfStudents;
    private int numberOfPartners;
    private int numberOfFacilitators;
    private int numberOfTasks;
    private int numberOfTags;
    private int maximumNumberOfTags;
    private int maximumNumberOfTasks;
    private long maximumNumberOfParticipants;
    private int maximumNumberOfStudents;
    private int maximumNumberOfPartners;
    private int maximumNumberOfFacilitators;
    private Participant[] participants;
    private Task[] tasks;
    private String[] tags;

    public ProjectImp(String name, String description, int numberOfParticipants, int numberOfStudents, int numberOfPartners, int numberOfTags, int numberOfFacilitators, int numberOfTasks, int maximumNumberOfTags, int maximumNumberOfTasks, long maximumNumberOfParticipants, int maximumNumberOfStudents, int maximumNumberOfPartners, int maximumNumberOfFacilitators, Participant[] participants, Task[] tasks, String[] tags) {
        this.name = name;
        this.description = description;
        this.numberOfParticipants = numberOfParticipants;
        this.numberOfStudents = numberOfStudents;
        this.numberOfPartners = numberOfPartners;
        this.numberOfFacilitators = numberOfFacilitators;
        this.numberOfTasks = numberOfTasks;
        this.numberOfTags = numberOfTags;
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

    public void addTag(String newTag) {

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
        throw new NullPointerException("Tag not found");
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
    public void addTask(Task task) throws IllegalNumberOfTasks, TaskAlreadyInProject {

        if (numberOfTasks == maximumNumberOfTasks) {
            throw new IllegalNumberOfTasks("Maximum number of tasks reached");
        }

        try {
            hasTask(task);
        } catch (TaskAlreadyInProject e) {
            System.out.println(e.getMessage());
        }
        this.tasks[this.numberOfTasks++] = task;
    }

    private void hasTask(Task task) throws TaskAlreadyInProject {
        for (int i = 0; i < numberOfTasks; i++) {
            if (this.tasks[i].equals(task)) {
                throw new TaskAlreadyInProject("Task already in project");
            }
        }
    }

    @Override
    public Task getTask(String s) {
        for (int i = 0; i < numberOfTasks; i++) {
            if (this.tasks[i].getTitle().equals(s)) {
                return this.tasks[i];
            }
        }
        return null;
    }

    @Override
    public Task[] getTasks() {
        return this.tasks;
    }

    @Override
    public boolean isCompleted() {
        for (int i = 0; i < numberOfTasks; i++) {
            if (tasks[i].getNumberOfSubmissions() == 0) {
                return false;
            }
        }
        return true;
    }
}

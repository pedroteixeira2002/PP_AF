package CBL;

import ma02_resources.project.Submission;
import ma02_resources.project.Task;

import java.time.LocalDate;

public class TaskImp implements Task {

    private static int SIZE = 10;
    private final int FATOR = 2;
    private String title;
    private String description;
    private LocalDate start;
    private LocalDate end;
    private int duration;
    private int extendDeadline;
    private Submission[] submissions;
    private int numberOfSubmissions;


    public TaskImp(String title, String description, LocalDate start, LocalDate end, int duration,int extendDeadline, Submission[] submissions, int numberOfSubmissions) {
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
        this.duration = duration;
        this.extendDeadline = extendDeadline;
        this.submissions = new Submission[SIZE];
        this.numberOfSubmissions = numberOfSubmissions;
    }
    @Override
    public LocalDate getStart() {
        return this.start;
    }

    @Override
    public LocalDate getEnd() {
        return this.end;
    }

    @Override
    public int getDuration() {
        return this.duration;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public Submission[] getSubmissions() {
        return this.submissions;
    }

    @Override
    public int getNumberOfSubmissions() {
        return this.numberOfSubmissions;
    }

    @Override
    public void addSubmission(Submission submission) {

    }

    @Override
    public void extendDeadline(int i) {

    }

    @Override
    public int compareTo(Task task) {
        return this.start.compareTo(task.getStart());
    }
}

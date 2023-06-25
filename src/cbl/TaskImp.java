package cbl;

import ma02_resources.project.Submission;
import ma02_resources.project.Task;

import java.time.LocalDate;
import java.util.Objects;

public class TaskImp implements Task {

    private static int SIZE = 10;
    private final int FACTOR = 2;
    private String title;
    private String description;
    private LocalDate start;
    private LocalDate end;
    private int duration;
    private int extendDeadline;
    private Submission[] submissions;
    private int numberOfSubmissions;

    public TaskImp(LocalDate EditionStart, String title, String description, int start,  int duration) {
        this.title = title;
        this.description = description;
        this.start = EditionStart.plusDays(start);
        this.end = EditionStart.plusDays(duration);
        this.duration = duration;
        this.extendDeadline = 0;
        this.submissions = new Submission[SIZE];
        this.numberOfSubmissions = 0;
    }


    public TaskImp(String title, String description, int duration,LocalDate start, LocalDate end, int numberOfSubmissions, Submission[] submissions) {
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
        this.duration = duration;
        this.numberOfSubmissions = numberOfSubmissions;
        this.submissions = submissions;
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
    public void addSubmission(Submission submission) throws IllegalArgumentException {

        if (submission == null) {
            throw new IllegalArgumentException("Submission is null");
        }

        try {
            hasSubmission(submission);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        if (this.numberOfSubmissions == this.submissions.length) {
            expandSubmissions();
        }

        this.submissions[numberOfSubmissions] = submission;
        this.numberOfSubmissions++;
    }

    private void expandSubmissions() {

        Submission[] temp = new Submission[this.submissions.length * FACTOR];

        for (int i = 0; i < numberOfSubmissions; i++) {
            temp[i] = this.submissions[i];
        }

        this.submissions = temp;
    }

    public void hasSubmission(Submission submission) throws IllegalArgumentException {
        for (int i = 0; i < numberOfSubmissions; i++) {
            if (this.submissions[i].equals(submission)) {
                throw new IllegalArgumentException("Submission already exists");
            }
        }
    }

    @Override
    public void extendDeadline(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Invalid number of days");
        } else {
            this.end = this.end.plusDays(i);
        }
    }

    @Override
    public int compareTo(Task task) {
        return this.start.compareTo(task.getStart());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Task other = (Task) obj;
        return Objects.equals(this.title, other.getTitle());
    }

    @Override
    public String toString() {
        return "\n -------Task-------" +
                "\n Title: " + title +
                "\n Description: " + description +
                "\n Start: " + start +
                "\n End: " + end +
                "\n Duration: " + duration +
                "\n Deadline extended by " + extendDeadline + " days" +
                "\n Submissions: " + submissions +
                "\n Number Of Submissions: " + numberOfSubmissions;
    }


}


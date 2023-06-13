package CBL;

import ma02_resources.project.Submission;
import ma02_resources.project.Task;

import java.time.LocalDate;

public class TaskImp implements Task {
    @Override
    public LocalDate getStart() {
        return null;
    }

    @Override
    public LocalDate getEnd() {
        return null;
    }

    @Override
    public int getDuration() {
        return 0;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public Submission[] getSubmissions() {
        return new Submission[0];
    }

    @Override
    public int getNumberOfSubmissions() {
        return 0;
    }

    @Override
    public void addSubmission(Submission submission) {

    }

    @Override
    public void extendDeadline(int i) {

    }

    @Override
    public int compareTo(Task task) {
        return 0;
    }
}

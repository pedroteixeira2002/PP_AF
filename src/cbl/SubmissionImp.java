package cbl;

import ma02_resources.participants.Student;
import ma02_resources.project.Submission;

import java.time.LocalDateTime;

public class SubmissionImp implements Submission {
    private LocalDateTime date;
    private Student student;
    private String text;

    public SubmissionImp(LocalDateTime date, Student student, String text) {
        this.date = date;
        this.student = student;
        this.text = text;
    }

    @Override
    public LocalDateTime getDate() {
        return this.date;
    }

    @Override
    public Student getStudent() {
        return this.student;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public int compareTo(Submission submission) {
        return this.date.compareTo(submission.getDate());
    }
}

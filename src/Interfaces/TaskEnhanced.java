package Interfaces;

import ma02_resources.participants.Student;
import ma02_resources.project.Submission;

public interface TaskEnhanced {

    void addSubmission(Submission submission, Student student) throws IllegalArgumentException;
}

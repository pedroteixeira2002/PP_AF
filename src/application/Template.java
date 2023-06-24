package application;

import ma02_resources.project.Task;

public class Template {
    private final int number_of_facilitators;
    private final int number_of_students;
    private final int number_of_parters;
    private final Task[] tasks;

    public Template(int number_of_facilitators, int number_of_students, int number_of_parters, Task[] tasks) {
        this.number_of_facilitators = number_of_facilitators;
        this.number_of_students = number_of_students;
        this.number_of_parters = number_of_parters;
        this.tasks = tasks;
    }

    public int getNumber_of_facilitators() {
        return number_of_facilitators;
    }

    public int getNumber_of_students() {
        return number_of_students;
    }

    public int getNumber_of_partners() {
        return number_of_parters;
    }

    public Task[] getTasks() {
        return tasks;
    }
}

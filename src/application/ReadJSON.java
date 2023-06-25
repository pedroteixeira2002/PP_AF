package application;

import Interfaces.Portfolio;
import cbl.PortfolioImp;
import cbl.SubmissionImp;
import cbl.TaskImp;
import ma02_resources.participants.Student;
import ma02_resources.project.Submission;
import ma02_resources.project.Task;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileReader;
import java.io.IOException;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReadJSON {
    private static ReadJSON instance;

    private ReadJSON() {

    }

    public static ReadJSON getInstance() {
        if (instance == null) {
            instance = new ReadJSON();
        }
        return instance;
    }


    public Template readTemplate(LocalDate editionStart, String path) throws IOException, java.text.ParseException {

        JSONParser parser = new JSONParser();

        try {
            Reader reader = new FileReader(path);
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            int number_of_facilitators = (int) jsonObject.get("number_of_facilitators");
            int number_of_students = (int) jsonObject.get("number_of_students");
            int number_of_partners = (int) jsonObject.get("number_of_partners");

            JSONArray tasks = (JSONArray) jsonObject.get("tasks");
            Task[] task = new Task[tasks.size()];

            for (int i = 0; i < tasks.size(); i++) {

                JSONObject taskTmp = (JSONObject) tasks.get(i);

                String task_title = (String) taskTmp.get("title");
                String task_description = (String) taskTmp.get("description");
                int start_at = (int) taskTmp.get("start_at");
                int duration = (int) taskTmp.get("duration");

                task[i] = new TaskImp(editionStart, task_title, task_description, start_at, duration);
            }
            return new Template(number_of_facilitators, number_of_students, number_of_partners, task);

        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        } catch (ParseException e) {
            throw new java.text.ParseException("msg", e.getPosition());
        }
        return null;
    }


    public Portfolio readJSON(String path) {
        Portfolio portfolio = new PortfolioImp();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(path)) { // Replace "data.json" with the path to your JSON file

            Object obj = parser.parse(reader);
            JSONArray editionsArray = (JSONArray) obj;

            // Loop through editions
            for (Object editionObj : editionsArray) {
                JSONObject edition = (JSONObject) editionObj;

                // Read edition details
                String name = (String) edition.get("name");
                String start = (String) edition.get("start");
                String end = (String) edition.get("end");
                String status = (String) edition.get("status");
                long numOfProjects = (long) edition.get("number_of_projects");
                long numOfEvents = (long) edition.get("number_of_events");

                System.out.println("Edition: " + name);
                System.out.println("Start: " + start);
                System.out.println("End: " + end);
                System.out.println("Status: " + status);
                System.out.println("Number of Projects: " + numOfProjects);
                System.out.println("Number of Events: " + numOfEvents);

                JSONArray eventsArray = (JSONArray) edition.get("events");
                // Loop through events
                for (Object eventObj : eventsArray) {
                    JSONObject event = (JSONObject) eventObj;

                    // Read event details
                    String location = (String) event.get("location");
                    String eventStart = (String) event.get("start");
                    String eventEnd = (String) event.get("end");
                    long numOfParticipants = (long) event.get("number_of_participants");

                    System.out.println("Event Location: " + location);
                    System.out.println("Event Start: " + eventStart);
                    System.out.println("Event End: " + eventEnd);
                    System.out.println("Number of Participants: " + numOfParticipants);

                    JSONArray participantsArray = (JSONArray) event.get("participants");
                    // Loop through participants
                    for (Object participantObj : participantsArray) {
                        JSONObject participant = (JSONObject) participantObj;

                        // Read participant details
                        String participantName = (String) participant.get("name");
                        String email = (String) participant.get("email");
                        String contact = (String) participant.get("contact");
                        String institution = (String) participant.get("institution");

                        System.out.println("Participant Name: " + participantName);
                        System.out.println("Email: " + email);
                        System.out.println("Contact: " + contact);
                        System.out.println("Institution: " + institution);
                    }
                }

                JSONArray projectsArray = (JSONArray) edition.get("project");
                // Loop through projects
                for (Object projectObj : projectsArray) {
                    JSONObject projectTmp = (JSONObject) projectObj;

                    // Read project details
                    String projectName = (String) projectTmp.get("name");
                    String projectDescription = (String) projectTmp.get("description");
                    long numOfProjectParticipants = (long) projectTmp.get("number_of_participants");
                    long numOfStudents = (long) projectTmp.get("number_of_students");
                    long numOfFacilitators = (long) projectTmp.get("number_of_facilitators");
                    long numOfPartners = (long) projectTmp.get("number_of_partners");

                    System.out.println("Project Name: " + projectName);
                    System.out.println("Project Description: " + projectDescription);
                    System.out.println("Number of Project Participants: " + numOfProjectParticipants);
                    System.out.println("Number of Students: " + numOfStudents);
                    System.out.println("Number of Facilitators: " + numOfFacilitators);
                    System.out.println("Number of Partners: " + numOfPartners);
                    JSONArray projectParticipantsArray = (JSONArray) projectTmp.get("participants");
                    // Loop through project participants
                    for (Object participantObj : projectParticipantsArray) {
                        JSONObject participant = (JSONObject) participantObj;

                        // Read participant details
                        String participantName = (String) participant.get("name");
                        String email = (String) participant.get("email");
                        String contact = (String) participant.get("contact");
                        String institution = (String) participant.get("institution");

                        System.out.println("Participant Name: " + participantName);
                        System.out.println("Email: " + email);
                        System.out.println("Contact: " + contact);
                        System.out.println("Institution: " + institution);
                    }

                    JSONArray tasks = (JSONArray) projectTmp.get("tasks");
                    Task[] task = new Task[tasks.size()];
                    // Loop through tasks
                    for (int i = 0; i < tasks.size(); i++) {

                        JSONObject taskTmp = (JSONObject) tasks.get(i);

                        // Read task details
                        String taskTitle = (String) taskTmp.get("title");
                        String taskDescription = (String) taskTmp.get("description");
                        long taskDuration = (long) taskTmp.get("duration");
                        LocalDate taskStart = (LocalDate) taskTmp.get("start");
                        LocalDate taskEnd = (LocalDate) taskTmp.get("end");
                        long numOfSubmissions = (long) taskTmp.get("number_of_submissions");

                        JSONArray submissions = (JSONArray) taskTmp.get("submissions");
                        Submission[] submission = new Submission[submissions.size()];

                        // Loop through submissions
                        for (int j = 0; i < submissions.size(); i++) {
                            JSONObject submissionTmp = (JSONObject) submissions.get(j);

                            // Read submission details
                            LocalDateTime submissionDate = (LocalDateTime) submissionTmp.get("date");
                            Student student = (Student) submissionTmp.get("student");
                            String submissionText = (String) submissionTmp.get("text");

                            submission[j] = new SubmissionImp(submissionDate, student, submissionText);
                        }

                        task[i] = new TaskImp(taskTitle, taskDescription, (int) taskDuration, taskStart, taskEnd, (int) numOfSubmissions, submission);
                    }
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return portfolio;
    }
}

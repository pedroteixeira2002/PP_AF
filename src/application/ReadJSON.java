package application;

import Interfaces.Event;
import Interfaces.Portfolio;
import Participants.*;
import cbl.*;
import enumerations.EventType;
import ma02_resources.participants.Contact;
import ma02_resources.participants.Instituition;
import ma02_resources.participants.Participant;
import ma02_resources.participants.Student;
import ma02_resources.project.*;
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
        try (FileReader reader = new FileReader(path)) {
            Object obj = parser.parse(reader);

            JSONArray editions = (JSONArray) obj;
            Edition[] edition = new Edition[editions.size()];

            // Loop through editions
            for (int a = 0; a < editions.size(); a++) {
                JSONObject editionTmp = (JSONObject) editions.get(a);

                // Read edition details
                String name = (String) editionTmp.get("name");
                LocalDate start = (LocalDate) editionTmp.get("start");
                LocalDate end = (LocalDate) editionTmp.get("end");
                Status status = (Status) editionTmp.get("status");
                long numOfProjects = (long) editionTmp.get("number_of_projects");
                long numOfEvents = (long) editionTmp.get("number_of_events");

                JSONArray events = (JSONArray) editionTmp.get("events");
                Event[] event = new Event[events.size()];

                // Loop through events
                for (int b = 0; b < events.size(); b++) {

                    JSONObject eventTmp = (JSONObject) events.get(b);

                    // Read event details
                    EventType type = (EventType) eventTmp.get("type");
                    String location = (String) eventTmp.get("location");
                    LocalDate eventStart = (LocalDate) eventTmp.get("start");
                    LocalDate eventEnd = (LocalDate) eventTmp.get("end");


                    JSONArray participants = (JSONArray) eventTmp.get("participants");
                    Participant[] participant = new Participant[participants.size()];
                    // Loop through participants
                    for (int c = 0; c < participants.size(); c++) {
                        JSONObject participantTmp = (JSONObject) participants.get(c);

                        // Read participant details
                        String participantName = (String) participantTmp.get("name");
                        String email = (String) participantTmp.get("email");
                        ContactImp contact = (ContactImp) participantTmp.get("contact");
                        InstituitionImp institution = (InstituitionImp) participantTmp.get("institution");

                        // Read specific details
                        String typeOfParticipant = (String) participantTmp.get("type");
                        if (typeOfParticipant.equals("student")) {
                            long studentNumber = (long) participantTmp.get("student_number");
                            participant[c] = new StudentImp(participantName, email, contact, institution, (int) studentNumber);
                        } else if (typeOfParticipant.equals("facilitator")) {
                            String areaOfExpertise = (String) participantTmp.get("area_of_expertise");
                            participant[c] = new FacilitatorImp(participantName, email, contact, institution, areaOfExpertise);
                        } else if (typeOfParticipant.equals("partner")) {
                            String website = (String) participantTmp.get("website");
                            String vat = (String) participantTmp.get("vat");
                            participant[c] = new PartnerImp(participantName, email, contact, institution, website, vat);
                        } else if (typeOfParticipant.equals("judge")) {
                            participant[c] = new JudgeImp(participantName, email, contact, institution);
                        }

                    }
                    event[b] = new EventImp(type, location, eventStart, eventEnd, participant);
                }

                JSONArray projects = (JSONArray) editionTmp.get("project");
                Project[] project = new Project[projects.size()];
                // Loop through projects
                for (int d = 0; d < projects.size(); d++) {

                    JSONObject projectTmp = (JSONObject) projects.get(d);

                    // Read project details
                    String projectName = (String) projectTmp.get("name");
                    String projectDescription = (String) projectTmp.get("description");
                    long numOfStudents = (long) projectTmp.get("number_of_students");
                    long numOfFacilitators = (long) projectTmp.get("number_of_facilitators");
                    long numOfPartners = (long) projectTmp.get("number_of_partners");
                    long rank = (long) projectTmp.get("rank");


                    JSONArray participants = (JSONArray) projectTmp.get("participants");
                    Participant[] participant = new Participant[participants.size()];

                    // Loop through project participants
                    for (int e = 0; e < participants.size(); e++) {
                        JSONObject participantTmp = (JSONObject) participants.get(d);

                        String type = (String) participantTmp.get("type");

                        // Read participant details
                        String participantName = (String) participantTmp.get("name");
                        String email = (String) participantTmp.get("email");
                        ContactImp contact = (ContactImp) participantTmp.get("contact");
                        InstituitionImp institution = (InstituitionImp) participantTmp.get("institution");

                        //read specific details
                        if (type.equals("student")) {
                            long studentNumber = (long) participantTmp.get("student_number");
                            participant[e] = new StudentImp(participantName, email, contact, institution, (int) studentNumber);
                        } else if (type.equals("facilitator")) {
                            String areaOfExpertise = (String) participantTmp.get("area_of_expertise");
                            participant[e] = new FacilitatorImp(participantName, email, contact, institution, areaOfExpertise);
                        } else if (type.equals("partner")) {
                            String website = (String) participantTmp.get("website");
                            String vat = (String) participantTmp.get("vat");
                            participant[e] = new PartnerImp(participantName, email, contact, institution, website, vat);
                        }
                    }
                    JSONArray tasks = (JSONArray) projectTmp.get("tasks");
                    Task[] task = new Task[tasks.size()];
                    // Loop through tasks
                    for (int f = 0; f < tasks.size(); f++) {

                        JSONObject taskTmp = (JSONObject) tasks.get(f);

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
                        for (int k = 0; k < submissions.size(); k++) {
                            JSONObject submissionTmp = (JSONObject) submissions.get(k);

                            // Read submission details
                            LocalDateTime submissionDate = (LocalDateTime) submissionTmp.get("date");
                            Student student = (Student) submissionTmp.get("student");
                            String submissionText = (String) submissionTmp.get("text");

                            submission[k] = new SubmissionImp(submissionDate, student, submissionText);
                        }

                        task[f] = new TaskImp(taskTitle, taskDescription, (int) taskDuration, taskStart, taskEnd, (int) numOfSubmissions, submission);
                    }

                    JSONArray tags = (JSONArray) projectTmp.get("tags");
                    String[] tag = new String[tags.size()];

                    //Loop through tags
                    for (int g = 0; g < tags.size(); g++) {
                        tag[g] = (String) tags.get(g);
                    }

                    project[d] = new ProjectImp(projectName, projectDescription, (int) numOfStudents, (int) numOfPartners, (int) numOfFacilitators, (int) rank, participant, task, tag);

                }
                edition[a] = new EditionImp(name, start, end, status, project, event);
            }
        } catch (IOException |
                 ParseException e) {
            e.printStackTrace();
        }
        return portfolio;
    }
}

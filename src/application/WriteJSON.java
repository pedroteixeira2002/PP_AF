package application;

import Interfaces.Event;
import cbl.PortfolioImp;
import ma02_resources.participants.Participant;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Submission;
import ma02_resources.project.Task;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import cbl.EditionImp;

import java.io.FileWriter;
import java.io.IOException;

public class WriteJSON {
    public WriteJSON() {
    }

    public void writeJSON() throws IOException {
        PortfolioImp portfolio = new PortfolioImp();
        JSONObject jsonObject = new JSONObject();

        try {
            FileWriter fileWriter = new FileWriter("\\json_files\\export.json");

            for (Edition edition : portfolio.getEditions()) {
                JSONObject editionDetails = new JSONObject();
                editionDetails.put("name", edition.getName());
                editionDetails.put("start", edition.getStart().toString());
                editionDetails.put("end", edition.getEnd().toString());
                editionDetails.put("status", edition.getStatus().toString());
                editionDetails.put("projects", edition.getNumberOfProjects());
                editionDetails.put("events", edition.getNumberOfEvents());

                JSONArray eventsArray = new JSONArray();

                for (Event event : edition.getEvents()) {
                    JSONObject eventDetails = new JSONObject();
                    eventDetails.put("location", event.getLocation());
                    eventDetails.put("start", event.getStartDate().toString());
                    eventDetails.put("end", event.getEndDate().toString());
                    eventDetails.put("participants", event.getNumberOfParticipants());

                    JSONArray participantsArray = new JSONArray();
                    for (Participant participant : event.getParticipants()) {
                        JSONObject participantDetails = new JSONObject();
                        participantDetails.put("name", participant.getName());
                        participantDetails.put("email", participant.getEmail());
                        participantDetails.put("type", participant.getContact());
                        participantDetails.put("status", participant.getInstituition().toString());
                        participantsArray.add(participantDetails);
                    }
                    eventDetails.put("participants", participantsArray);

                    eventsArray.add(eventDetails);
                }
                editionDetails.put("events", eventsArray);

                JSONArray projectsArray = new JSONArray();
                for (Project project : edition.getProjects()) {
                    JSONObject projectDetails = new JSONObject();
                    projectDetails.put("name", project.getName());
                    projectDetails.put("description", project.getDescription());
                    projectDetails.put("participants", project.getNumberOfParticipants());
                    projectDetails.put("students", project.getNumberOfStudents());
                    projectDetails.put("facilitators", project.getNumberOfFacilitators());
                    projectDetails.put("partners", project.getNumberOfPartners());

                    JSONArray projectParticipantsArray = new JSONArray();
                    for (Participant participant : project.getParticipants()) {
                        JSONObject participantDetails = new JSONObject();
                        participantDetails.put("name", participant.getName());
                        participantDetails.put("email", participant.getEmail());
                        participantDetails.put("type", participant.getContact());
                        participantDetails.put("status", participant.getInstituition().toString());
                        projectParticipantsArray.add(participantDetails);
                    }
                    projectDetails.put("participants", projectParticipantsArray);

                    JSONArray tasksArray = new JSONArray();
                    for (Task task : project.getTasks()) {
                        JSONObject taskDetails = new JSONObject();
                        taskDetails.put("title", task.getTitle());
                        taskDetails.put("description", task.getDescription());
                        taskDetails.put("duration", task.getDuration());
                        taskDetails.put("start", task.getStart().toString());
                        taskDetails.put("end", task.getEnd().toString());
                        taskDetails.put("number of submissions", task.getNumberOfSubmissions());

                        JSONArray submissionsArray = new JSONArray();
                        for (Submission submission : task.getSubmissions()) {
                            JSONObject submissionDetails = new JSONObject();
                            submissionDetails.put("date", submission.getDate().toString());
                            submissionDetails.put("student", submission.getStudent());
                            submissionDetails.put("text", submission.getText());
                            submissionsArray.add(submissionDetails);
                        }
                        taskDetails.put("submissionsDetails", submissionsArray);

                        tasksArray.add(taskDetails);
                    }
                    projectDetails.put("tasksDetails", tasksArray);

                    projectsArray.add(projectDetails);
                }
                editionDetails.put("projectsDetails", projectsArray);

                fileWriter.write(editionDetails.toJSONString());
            }

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("JSON file created: " + jsonObject);
    }
}

package application;

import Interfaces.Event;
import Participants.ParticipantImp;
import cbl.PortfolioImp;
import cbl.ProjectImp;

import ma02_resources.participants.Participant;

import ma02_resources.project.Edition;
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

        PortfolioImp portfolioTmp = new PortfolioImp();
        JSONObject jsonObject = new JSONObject();

        try {
            FileWriter fileWriter = new FileWriter("\\json_files\\export.json");

            JSONArray editionsArray = new JSONArray();

            for (EditionImp editionTmp : portfolioTmp.getEditions()) {
                JSONObject edition = new JSONObject();
                edition.put("name", editionTmp.getName());
                edition.put("start", editionTmp.getStart().toString());
                edition.put("end", editionTmp.getEnd().toString());
                edition.put("status", editionTmp.getStatus().toString());
                edition.put("number_of_projects", editionTmp.getNumberOfProjects());
                edition.put("number_of_events", editionTmp.getNumberOfEvents());

                JSONArray eventsArray = new JSONArray();

                for (Event eventTmp : editionTmp.getEvents()) {
                    JSONObject event = new JSONObject();
                    event.put("location", eventTmp.getLocation());
                    event.put("start", eventTmp.getStartDate().toString());
                    event.put("end", eventTmp.getEndDate().toString());
                    event.put("number_of_participants", eventTmp.getNumberOfParticipants());

                    JSONArray participantsArray = new JSONArray();

                    for (Participant participantTmp : eventTmp.getParticipants()) {
                        JSONObject participant = new JSONObject();
                        participant.put("name", participantTmp.getName());
                        participant.put("email", participantTmp.getEmail());
                        participant.put("contact", participantTmp.getContact());
                        participant.put("institution", participantTmp.getInstituition().toString());
                        participantsArray.add(participant);
                    }
                    event.put("participants", participantsArray);

                    eventsArray.add(event);
                }

                edition.put("events", eventsArray);
                JSONArray projectsArray = new JSONArray();

                for (ProjectImp projectTmp : editionTmp.getProjects()) {
                    JSONObject project = new JSONObject();
                    project.put("name", projectTmp.getName());
                    project.put("description", projectTmp.getDescription());
                    project.put("number_of_participants", projectTmp.getNumberOfParticipants());
                    project.put("number_of_students", projectTmp.getNumberOfStudents());
                    project.put("number_of_facilitators", projectTmp.getNumberOfFacilitators());
                    project.put("number_of_partners", projectTmp.getNumberOfPartners());

                    JSONArray projectParticipantsArray = new JSONArray();

                    for (ParticipantImp participantTmp : projectTmp.getParticipants()) {
                        JSONObject participant = new JSONObject();
                        participant.put("name", participantTmp.getName());
                        participant.put("email", participantTmp.getEmail());
                        participant.put("contact", participantTmp.getContact());
                        participant.put("institution", participantTmp.getInstituition().toString());

                        projectParticipantsArray.add(participant);
                    }

                    project.put("participants", projectParticipantsArray);

                    JSONArray tasksArray = new JSONArray();

                    for (Task taskTmp : projectTmp.getTasks()) {
                        JSONObject task = new JSONObject();
                        task.put("title", taskTmp.getTitle());
                        task.put("description", taskTmp.getDescription());
                        task.put("duration", taskTmp.getDuration());
                        task.put("start", taskTmp.getStart().toString());
                        task.put("end", taskTmp.getEnd().toString());
                        task.put("number of submissions", taskTmp.getNumberOfSubmissions());

                        JSONArray submissionsArray = new JSONArray();

                        for (Submission submissionTmp : taskTmp.getSubmissions()) {
                            JSONObject submission = new JSONObject();
                            submission.put("date", submissionTmp.getDate().toString());
                            submission.put("student", submissionTmp.getStudent());
                            submission.put("text", submissionTmp.getText());

                            submissionsArray.add(submission);
                        }

                        task.put("submissions", submissionsArray);
                        tasksArray.add(task);
                    }

                    project.put("tasks", tasksArray);
                    projectsArray.add(project);
                }

                edition.put("project", projectsArray);
                editionsArray.add(edition);
            }
            jsonObject.put("editions", editionsArray);
            fileWriter.write(jsonObject.toJSONString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("JSON file created: " + jsonObject);
    }
}

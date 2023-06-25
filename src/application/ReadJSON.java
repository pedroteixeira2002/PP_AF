package application;

import Interfaces.Portfolio;
import cbl.PortfolioImp;
import cbl.TaskImp;
import ma02_resources.project.Task;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileReader;
import java.io.IOException;

import java.io.*;
import java.time.LocalDate;

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
                JSONObject project = (JSONObject) tasks.get(i);

                String task_title = (String) project.get("title");
                String task_description = (String) project.get("description");
                int start_at = (int) project.get("start_at");
                int duration = (int) project.get("duration");

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

    public PortfolioImp readJson(String path) {
        JSONParser parser = new JSONParser();

        try {
            Reader reader = new FileReader(path);
            JSONObject portfolio = (JSONObject) parser.parse(reader);



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Portfolio readJSON() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("\\json_files\\export.json")) {
            Object obj = parser.parse(reader);
            JSONArray editionsArray = (JSONArray) obj;

            for (Object editionObj : editionsArray) {
                JSONObject editionJSON = (JSONObject) editionObj;
                String name = (String) editionJSON.get("name");
                // Read other properties of the edition as needed

                JSONArray eventsArray = (JSONArray) editionJSON.get("events");

                for (Object eventObj : eventsArray) {
                    JSONObject eventJSON = (JSONObject) eventObj;
                    String location = (String) eventJSON.get("location");
                    // Read other properties of the event as needed

                    JSONArray participantsArray = (JSONArray) eventJSON.get("participants");
                    for (Object participantObj : participantsArray) {
                        JSONObject participantJSON = (JSONObject) participantObj;
                        String participantName = (String) participantJSON.get("name");
                        // Read other properties of the participant as needed
                    }
                }

                JSONArray projectsArray = (JSONArray) editionJSON.get("projectsDetails");
                for (Object projectObj : projectsArray) {
                    JSONObject projectJSON = (JSONObject) projectObj;
                    String projectName = (String) projectJSON.get("name");
                    // Read other properties of the project as needed

                    JSONArray projectParticipantsArray = (JSONArray) projectJSON.get("participants");
                    for (Object participantObj : projectParticipantsArray) {
                        JSONObject participantJSON = (JSONObject) participantObj;
                        String participantName = (String) participantJSON.get("name");
                        // Read other properties of the participant as needed
                    }

                    JSONArray tasksArray = (JSONArray) projectJSON.get("tasksDetails");
                    for (Object taskObj : tasksArray) {
                        JSONObject taskJSON = (JSONObject) taskObj;
                        String taskTitle = (String) taskJSON.get("title");
                        // Read other properties of the task as needed

                        JSONArray submissionsArray = (JSONArray) taskJSON.get("submissionsDetails");
                        for (Object submissionObj : submissionsArray) {
                            JSONObject submissionJSON = (JSONObject) submissionObj;
                            String submissionDate = (String) submissionJSON.get("date");
                            // Read other properties of the submission as needed
                        }
                    }
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return portfolio;
    }


}

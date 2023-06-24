package application;

import cbl.TaskImp;
import ma02_resources.project.Task;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
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

    public Template readJSON(LocalDate editionStart, String path) throws IOException, java.text.ParseException {

        try {
            Reader reader = new FileReader(path);

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            reader.close();

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

}

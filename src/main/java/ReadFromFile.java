import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

/**
 * ReadFromFile
 */
public class ReadFromFile {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static TaskList read() {
        File file = new File("todoly.json");
        TaskList taskList;

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            JsonReader jsonReader = new JsonReader(inputStreamReader);

            taskList = gson.fromJson(jsonReader, TaskList.class);
        } catch (Exception e) {
            taskList = new TaskList();
        }

        return taskList;
    }

}
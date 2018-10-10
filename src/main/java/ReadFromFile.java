import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

/**
 * The class ReadFromFile reads from file that store the tasks list. It uses
 * Gson to convert a Json string to an equivalent Java object.
 *
 * @author Gloria Morales
 * @version 2018.10.10
 *
 */
public class ReadFromFile {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Read tasks from file "todoly.json"
     *
     * @return The list of tasks.
     */
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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * The class WriteToFile writes into the file that store the tasks list. It uses
 * Gson to convert Java Objects into Json string.
 *
 * @author Gloria Morales
 * @version 2018.10.10
 *
 */
public class WriteToFile {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Save to file "todoly.json"
     *
     * @param taskList The list of tasks.
     */
    public static void write(TaskList taskList) {
        File file = new File("todoly.json");
        String json = gson.toJson(taskList);

        try {
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(json);
            bufferedWriter.close();
        } catch (Exception e) {
        }
    }
}
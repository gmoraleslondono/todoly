import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * WriteToFile
 */
public class WriteToFile {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

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
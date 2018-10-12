import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

import com.gmoraleslondono.todoly.Task;

public class TaskTest {
    @Test
    public void testTaskHasTitleDueDateStatusAndProject() {
        String title = "title";
        LocalDate dueDate = LocalDate.now();
        Boolean status = true;
        String project = "project";
        Task task = new Task(title, dueDate, status, project);
        assertEquals("task should have a title", title, task.getTitle());
        assertEquals("task should have a due date", dueDate, task.getDueDate());
        assertEquals("task should have a status", status, task.getStatus());
        assertEquals("task should have a project", project, task.getProject());
    }
}
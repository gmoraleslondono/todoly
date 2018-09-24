import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

public class TaskTest {
    @Test
    public void testTaskHasTitleDueDateStatusAndProject() {
        String title = "title";
        LocalDate dueDate = LocalDate.now();
        Boolean status = true;
        String tomas = "project";
        Task task = new Task(title, dueDate, status, tomas);
        assertEquals("task should have a title", title, task.getTitle());
        assertEquals("task should have a due date", dueDate, task.getDueDate());
        assertEquals("task should have a status", status, task.getStatus());
        assertEquals("task should have a project", tomas, task.getProject());
    }
}
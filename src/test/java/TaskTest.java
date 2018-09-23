import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

public class TaskTest {
    @Test
    public void testTaskHasTitle() {
        Task task = new Task();
        assertTrue("task should have a title", task.getTitle() instanceof String);
    }

    @Test
    public void testTaskHasDueDate() {
        Task task = new Task();
        assertTrue("task should have a due date", task.getDueDate() instanceof LocalDate);
    }

    @Test
    public void testTaskHasStatus() {
        Task task = new Task();
        assertTrue("task should have a status", task.getStatus() instanceof Boolean);
    }
}
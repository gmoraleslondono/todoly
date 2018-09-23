import org.junit.Test;
import static org.junit.Assert.*;

public class TaskTest {
    @Test 
    public void testTaskHasTitle() {
        Task task = new Task();
        assertTrue("task should have a title", task.getTitle() instanceof String);
    }
}
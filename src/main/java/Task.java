import java.time.LocalDate;

public class Task {
    public String getTitle() {
        return "Hello world.";
    }

	public LocalDate getDueDate() {
		return LocalDate.now();
    }
    
	public Boolean getStatus() {
		return true;
	}

	public String getProject() {
		return "Hello world.";
	}
}
import java.time.LocalDate;

public class Task {
    private String title;
    private LocalDate dueDate;
    private Boolean status;
    private String project;

    public Task() {
	}

    public Task(
        String title, 
        LocalDate dueDate, 
        Boolean status, 
        String project
    ) {
        this.title = title;
        this.dueDate = dueDate;
        this.status = status;
        this.project = project;
    }

	public String getTitle() {
        return title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getProject() {
        return project;
    }
}
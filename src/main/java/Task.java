import java.time.LocalDate;

/**
 * Task stores the details of a task, such as title, due date, status and
 * project.
 *
 * @author Gloria Morales
 * @version 2018.10.01
 *
 */
public class Task implements Comparable<Task> {

    private String title;
    private LocalDate dueDate;
    private Boolean status;
    private String project;

    /**
     * Constructor for objects of class Task.
     *
     * @param title   The task's title.
     * @param dueDate The task's due date.
     * @param status  The task's status.
     * @param project The task's project.
     */
    public Task(String title, LocalDate dueDate, Boolean status, String project) {
        this.title = title;
        this.dueDate = dueDate;
        this.status = status;
        this.project = project;
    }

    /**
     * Return the title.
     *
     * @return The title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Return the due date.
     *
     * @return The dueDate.
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Return the status.
     *
     * @return The status.
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * Return the project.
     *
     * @return The project.
     */
    public String getProject() {
        return project;
    }

    /**
     * Return the details of a task: title, due date, status, and project.
     *
     * @return The task's details.
     */
    public String toString() {

        String statusToString;

        if (status == false) {
            statusToString = "TODO";
        } else {
            statusToString = "DONE";
        }

        return dueDate + " " + statusToString + " " + project + "\t" + title;
    }

    /**
     * Set task's title.
     *
     * @param title The title of the task.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Set task's due date.
     *
     * @param dueDate The due date of the task.
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Set task's status.
     *
     * @param status The status of the task.
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * Set task's project.
     *
     * @param project The project of the task.
     */
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * Return -1,0 or 1 depens of the result of the comparation.
     *
     * @return An integer -1, 0 or 1.
     */
    public int compareTo(Task task) {
        return dueDate.compareTo(task.getDueDate());
    }
}
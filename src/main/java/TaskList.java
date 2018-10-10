import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TaskList stores the list and details of task.
 *
 * @author Gloria Morales
 * @version 2018.10.01
 */
public class TaskList {

    private List<Task> listOfTasks;

    /**
     * Create a list for objects of class TaskList.
     */
    public TaskList() {
        listOfTasks = new ArrayList<Task>();
    }

    /**
     * Add a new task item to the task list.
     *
     * @param task The new task.
     */
    public void addTask(Task task) {
        listOfTasks.add(task);
    }

    /**
     * Remove a task item from the task list.
     *
     * @param task The task to remove.
     */
    public void removeTask(Task task) {
        listOfTasks.remove(task);
    }

    /**
     * Set as done a task in the task list.
     *
     * @param task The task to set as done.
     */
    public void setAsDone(Task task) {
        task.setStatus(true);
    }

    /**
     * Return a list of all the tasks details in the collection.
     *
     * @return The list of tasks.
     */
    public List<Task> getListOfTasks() {
        return listOfTasks;
    }

    /**
     * Return the number of tasks in the collection.
     *
     * @return The size of list of tasks.
     */
    public int getSize() {
        return listOfTasks.size();
    }

    /**
     * Sort the tasks list by due date.
     *
     * @return listOfTasks The list of tasks sorted by due date.
     */
    public List<Task> getTaskListSortedByDueDate() {
        Collections.sort(listOfTasks);
        return listOfTasks;
    }

    /**
     * Filter the tasks list by project.
     *
     * @param project The project to filter.
     * @return a new list of task filter by project.
     */
    public List<Task> filterTaskListByProject(String project) {
        List<Task> tasksByFilter = new ArrayList<>();
        for (Task task : listOfTasks) {
            if (task.getProject().equals(project)) {
                tasksByFilter.add(task);
            }
        }
        Collections.sort(tasksByFilter);
        return tasksByFilter;

    }

    /**
     * Return a list of projects.
     *
     * @return projects The list of projects.
     */
    public List<String> getProjects() {
        List<String> projects = new ArrayList<>();
        for (Task p : listOfTasks) {
            if (!projects.contains(p.getProject())) {
                projects.add(p.getProject());
            }
        }
        return projects;
    }

    /**
     * Return the number of tasks mark as done.
     *
     * @return numberOfTasksDone The number of tasks done.
     */
    public int getNumberOfTasksDone() {
        int numberOfTasksDone = 0;
        for (Task t : listOfTasks) {
            if (t.getStatus().equals(true)) {
                numberOfTasksDone++;
            }
        }
        return numberOfTasksDone;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }
}
import java.util.ArrayList;
/**
* TaskList stores the list and details of task.
*
* @author Gloria Morales
* @version 2018.10.01
*/
public class TaskList {

    private ArrayList<Task> listOfTasks;

    /**
    * Create a list for objects of class TaskList.
    */
    public TaskList() {
        listOfTasks = new ArrayList<Task>();
    }

    /**
     * Add a new task item to the task list.
     * @param task The new task.
     */
    public void addTask(Task task) {
        listOfTasks.add(task);
    }

    /**
     * Edit a task item in the task list.
     * @param task The task to edit.
     */
    public void editTask(Task task) {
        // 1. remove old task
        // 2. add new task
    }

    /**
     * Remove a task item from the task list.
     * @param task The task to remove.
     */
    public void removeTask(Task task) {
        listOfTasks.remove(task);
    }

    /**
     * Set as done a task in the task list.
     * @param task The task to set as done.
     */
    public void setAsDone(Task task) {
        task.setStatus(true);
        this.editTask(task);
    }

    /**
     * Return a list of all the tasks details in the collection.
     * @return The list of tasks.
     */
    public ArrayList<Task> getListOfTasks() {
        return listOfTasks;
    }

    /**
     * Return the number of tasks in the collection.
     * @return The size of list of tasks.
     */
    public int getSize() {
        return listOfTasks.size();
    }

}
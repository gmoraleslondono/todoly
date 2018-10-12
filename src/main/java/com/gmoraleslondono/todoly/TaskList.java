package com.gmoraleslondono.todoly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The TaskList class stores a list of task. Details are store such as
 * dynamically sized collection of elements.
 *
 * @author Gloria Morales
 * @version 2018.10.10
 *
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
     * @return The list of tasks sorted by due date.
     */
    public List<Task> getTaskListSortedByDueDate() {
        Collections.sort(listOfTasks);
        return listOfTasks;
    }

    /**
     * Filter the tasks list by project.
     *
     * @param project The project to filter.
     * @return New list of task filter by project.
     */
    public List<Task> filterTaskListByProject(String project) {
        List<Task> tasksByFilter = listOfTasks.stream().filter(task -> task.getProject().equals(project))
                .collect(Collectors.toList());
        return tasksByFilter;
    }

    /**
     * Return a list of projects.
     *
     * @return The list of projects.
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
     * @return The number of tasks done.
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

    /**
     * Return a boolean to identify wether or not there are tasks in the list.
     *
     * @return The value true or false.
     */
    public boolean isEmpty() {
        return getSize() == 0;
    }
}
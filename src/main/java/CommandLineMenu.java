import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * CommandLineMenu reads user input. It checks user input against the known
 * commands, and if the input is not one of the known commands, it returns a
 * command object that is marked as an unknown command.
 *
 * @author Gloria Morales
 * @version 2018.10.01
 */
public class CommandLineMenu {

    private Scanner scanner;
    private TaskList taskList;

    /**
     * Create an scanner that reads text from the terminal.
     */
    public CommandLineMenu() {
        scanner = new Scanner(System.in);
        taskList = new TaskList();
        this.displayMenu();
    }

    /**
     * Print a welcome message to the screen and give a list the option.
     */
    private void displayMenu() {
        int option = 0;

        while (option != 4) {
            int numberOfTasks = taskList.getSize();
            int numberOfTasksDone = taskList.getNumberOfTasksDone();

            System.out.println();
            System.out.println(">> Welcome to ToDoLy.");
            System.out.println(
                    ">> you have " + numberOfTasks + " tasks todo and " + numberOfTasksDone + " tasks are done!");
            System.out.println(">> Pick an option:");
            System.out.println(">> (1) Show Task List (By date or project)");
            System.out.println(">> (2) Add New Task.");
            System.out.println(">> (3) Edit Task (update, mark as done, remove)");
            System.out.println(">> (4) Save and Quit.");
            System.out.println(">>");

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
            }

            switch (option) {
            case 1:
                this.showTaskList();
                break;
            case 2:
                this.addNewTask();
                break;
            case 3:
                this.pickTaskToEdit();
                break;
            case 4:
                this.saveAndQuit();
                break;
            default:
                System.out.println("Introduce a valid value.");
                break;
            }
        }
    }

    /**
     * Print a list of options to show an ordered list of tasks by due date or
     * filtered by project.
     */
    private void showTaskList() {
        int option = 0;

        while (option != 3) {
            System.out.println();
            System.out.println(">> Pick an option:");
            System.out.println(">> (1) Show Task List By due date.");
            System.out.println(">> (2) Filter Task List By project.");
            System.out.println(">> (3) Back to home.");
            System.out.println(">>");

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
            }

            switch (option) {
            case 1:
                showTaskListByDueDate();
                displayMenu();
                break;
            case 2:
                selectProject();
                displayMenu();
                break;
            case 3:
                displayMenu();
                break;
            default:
                System.out.println("Introduce a valid value.");
                break;
            }
        }
    }

    /**
     * Show task list sorted by due date.
     */
    private void showTaskListByDueDate() {
        System.out.println();
        List<Task> taskListSortedByDueDate = taskList.getTaskListSortedByDueDate();
        for (Task t : taskListSortedByDueDate) {
            System.out.println(t);
        }
    }

    /**
     * Print a numbered list of projects and give details about the tasks belog to
     * the project selected.
     */
    public void selectProject() {
        List<String> projects = taskList.getProjects();
        String selectedProject;
        int option = 0;

        while (true) {
            System.out.println();
            System.out.println(">> Pick project:");

            for (int i = 0; i < projects.size(); i++) {
                System.out.println(">> (" + (i + 1) + ") " + projects.get(i));
            }
            System.out.println(">>");

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
            }

            if (option > 0 && option <= projects.size()) {
                selectedProject = projects.get(option - 1);
                List<Task> taskselected = taskList.filterTaskListByProject(selectedProject);
                for (Task t : taskselected) {
                    System.out.println(t);
                }
                break;
            } else {
                System.out.println("Introduce a valid value.");
            }
        }
    }

    /**
     * Add a new task to the list.
     */
    public void addNewTask() {
        System.out.println();
        System.out.print("Add title: ");
        String title = scanner.nextLine();

        boolean invalidDate = true;
        LocalDate localDate = null;

        while (invalidDate) {
            System.out.print("Add due date [yyyy-mm-dd]: ");
            String dueDateStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try {
                localDate = LocalDate.parse(dueDateStr, formatter);
                invalidDate = false;
            } catch (Exception e) {
                System.out.println("Introduce a valid date.");
            }
        }

        Boolean status = false;

        System.out.print("Add project: ");
        String project = scanner.nextLine();

        Task newTask = new Task(title, localDate, status, project);
        taskList.addTask(newTask);
    }

    /**
     * Print a numbered list of task.
     */
    public void pickTaskToEdit() {
        List<Task> tasks = taskList.getListOfTasks();
        int option = 0;

        while (true) {
            System.out.println();
            System.out.println(">> Pick task to edit:");

            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println(">> (" + (i + 1) + ") " + task.toString());
            }
            System.out.println(">>");

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
            }

            if (option > 0 && option <= tasks.size()) {
                Task selectedTask = tasks.get(option - 1);
                chooseWhatToEdit(selectedTask);
                break;
            } else {
                System.out.println("Introduce a valid value.");
            }
        }
    }

    /**
     * Print a list of options to edit a task.
     *
     * @param selectedTask The task to edit.
     */
    private void chooseWhatToEdit(Task selectedTask) {
        int option = 0;
        while (option != 4) {
            System.out.println();
            System.out.println(">> Pick option:");
            System.out.println(">> (1) Update (Title, Due date or Project)");
            System.out.println(">> (2) Mark as done");
            System.out.println(">> (3) Remove task");
            System.out.println(">> (4) Back to home");
            System.out.println(">>");

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
            }

            switch (option) {
            case 1:
                updateTask(selectedTask);
                displayMenu();
                break;
            case 2:
                markAsDone(selectedTask);
                displayMenu();
                break;
            case 3:
                eliminateTask(selectedTask);
                displayMenu();
                break;
            case 4:
                displayMenu();
                break;
            default:
                System.out.println("Introduce a valid value.");
                break;
            }
        }
    }

    /**
     * Update a task
     *
     * @param selectedTask The task to update.
     */
    public void updateTask(Task selectedTask) {
        System.out.println();
        System.out.println("Current value: " + selectedTask.getTitle());
        System.out.print("Add new title: ");
        String newTitle = scanner.nextLine();
        selectedTask.setTitle(newTitle);

        boolean invalidDate = true;

        while (invalidDate) {
            System.out.println("Current value: " + selectedTask.getDueDate());
        System.out.print("Add new due date [yyyy-mm-dd]: ");
        String dueDateStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try {
        LocalDate newDueDate = LocalDate.parse(dueDateStr, formatter);
        selectedTask.setDueDate(newDueDate);
                invalidDate = false;
            } catch (Exception e) {
                System.out.println("Introduce a valid date.");
            }
        }

        System.out.println("Current value: " + selectedTask.getProject());
        System.out.print("Add new project: ");
        String newProject = scanner.nextLine();
        selectedTask.setProject(newProject);
    }

    /**
     *
     * @param selectedTask
     */
    private void markAsDone(Task selectedTask) {
        taskList.setAsDone(selectedTask);
    }

    /**
     *
     * @param selectedTask
     */
    private void eliminateTask(Task selectedTask) {
        taskList.removeTask(selectedTask);
    }

    public void saveAndQuit() {
        System.out.println();
        System.out.println("Save and Quit");
        scanner.close();
        System.exit(0);
    }
}
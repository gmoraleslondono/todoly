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
     * Print a welcome message to the screen and give a list the option to select
     * and return one response.
     */
    private void displayMenu() {
        int option = 0;

        while (option != 4) {
            System.out.println(">> Welcome to ToDoLy.");
            System.out.println(">> you have " + taskList.getSize() + " tasks todo and y tasks are done!");
            System.out.println(">> Pick an option:");
            System.out.println(">> (1) Show Task List (By date or project)");
            System.out.println(">> (2) Add New Task.");
            System.out.println(">> (3) Edit Task (update, mark as done, remove)");
            System.out.println(">> (4) Save and Quit.");
            System.out.println(">>");
            option = scanner.nextInt();

            switch (option) {
            case 1:
                this.showTaskList();
                break;
            case 2:
                this.addNewTask();
                break;
            case 3:
                this.editTaskList();
                break;
            case 4:
                this.SaveQuitTaskList();
                break;
            default:
                System.out.println("Introduce a valid value.");
                break;
            }
        }
    }

    /**
     *
     */
    private void showTaskList() {
        int option = 0;

        while (option != 3) {
            System.out.println(">> Pick an option:");
            System.out.println(">> (1) Show Task List By due date.");
            System.out.println(">> (2) Filter Task List By project.");
            System.out.println(">> (3) Exit");
            System.out.println(">>");

            option = scanner.nextInt();

            switch (option) {
            case 1:
                showTaskListByDueDate();
                break;
            case 2:
                selectProject();
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

    private void showTaskListByDueDate() {
        List<Task> taskListSortedByDueDate = taskList.getTaskListSortedByDueDate();
        for (Task t : taskListSortedByDueDate) {
            System.out.println(t.getDetails());
        }
    }

    /**
     *
     */
    private void selectProject() {
        List<String> projects = taskList.getProjects();
        String selectedProject;
        int option = 0;

        while (true) {
            System.out.println(">> Pick project:");

            for (int i = 0; i < projects.size(); i++) {
                System.out.println(">> (" + (i + 1) + ") " + projects.get(i));
            }
            System.out.println(">>");

            option = scanner.nextInt();

            if (option <= projects.size()) {
                selectedProject = projects.get(option - 1);
                List<Task> taskselected = taskList.filterTaskListByProject(selectedProject);
                for (Task t : taskselected) {
                    System.out.println(t.getDetails());
                }
                break;
            } else {
                System.out.println("Introduce a valid value.");
            }
        }
    }

    /**
     *
     */
    private void addNewTask() {
        System.out.println("Add title");
        String title = scanner.next();

        System.out.println("Add due date [yyyy-mm-dd]");
        String dueDateStr = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dueDateStr, formatter);

        Boolean status = false;

        System.out.println("Add project");
        String project = scanner.next();

        Task newTask = new Task(title, localDate, status, project);
        taskList.addTask(newTask);
    }

    /**
     *
     */
    private void editTaskList() {
        System.out.println("edit task");
    }

    /**
     *
     */
    private void SaveQuitTaskList() {
        System.out.println("Save and Quit");
    }
}
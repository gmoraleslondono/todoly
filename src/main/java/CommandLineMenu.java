import java.util.Scanner;

/**
 * CommandLineMenu reads user input.
 * It checks user input against the known commands, and if the input 
 * is not one of the known commands, it returns a command object that 
 * is marked as an unknown command.
 * 
 * @author Gloria Morales
 * @version 2018.10.01
 */
public class CommandLineMenu {

    private Scanner scanner;
    private TaskList taskList;

    /**
     * 
     */
    public CommandLineMenu() {
        scanner = new Scanner(System.in);
        taskList = new TaskList();
        this.displayMenu();
    }

    /**
     * 
     */
    private void displayMenu() {
        int option = 0;

        while (option != 4) {
            System.out.println(">> Welcome to ToDoLy.");
            System.out.println(">> you have " + taskList.getSize() + " tasks todo and y tasks are done!");
            System.out.println(">> Pick an option:");
            System.out.println(">> (1) Show Task List (By date or project)");
            System.out.println(">> (2) Add New Task");
            System.out.println(">> (3) Edit Task (update, mark as done, remove)");
            System.out.println(">> (4) Save and Quit");
            System.out.println(">>");
            option = scanner.nextInt();

            /**
             * 
             */
            switch (option) {
            case 1:
                this.showTaskList();
                break;
            case 2:
                this.addTaskList();
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
        System.out.println("Show task list");
    }

    /**
     * 
     */
    private void addTaskList() {
        System.out.println("Add new task");
    }

    /**
     * 
     */
    private void editTaskList() {
        System.out.println("Edit task");
    }

    /**
     * 
     */
    private void SaveQuitTaskList() {
        System.out.println("Save and Quit");
    }

}
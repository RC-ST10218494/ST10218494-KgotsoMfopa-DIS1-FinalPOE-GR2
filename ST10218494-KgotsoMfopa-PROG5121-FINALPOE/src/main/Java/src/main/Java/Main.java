package src.main.Java;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<User> users = new ArrayList<>();
    private static List<Task> tasks = new ArrayList<>();
    private static User loggedInUser = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            if (loggedInUser == null) {
                showMainMenu();
            } else {
                showUserMenu();
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                register();
                break;
            case 2:
                login();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    private static void register() {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();

        User user = new User(username, password, firstName, lastName);
        String message = Login.registerUser(user);
        if (message.equals("User registered successfully.")) {
            users.add(user);
        }
        System.out.println(message);
    }

    private static void login() {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                loggedInUser = user;
                System.out.println("Welcome " + user.getFirstName() + ", it is great to see you again.");
                return;
            }
        }
        System.out.println("Username or password incorrect, please try again.");
    }

    private static void showUserMenu() {
        System.out.println("Welcome to EasyKanban");
        System.out.println("1. Add tasks");
        System.out.println("2. Show report");
        System.out.println("3. Quit");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addTasks();
                break;
            case 2:
                System.out.println("Coming Soon");
                break;
            case 3:
                loggedInUser = null;
                break;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    private static void addTasks() {
        System.out.println("How many tasks do you want to add?");
        int numTasks = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numTasks; i++) {
            System.out.println("Enter task name:");
            String taskName = scanner.nextLine();
            System.out.println("Enter task description (max 50 characters):");
            String taskDescription = scanner.nextLine();
            while (!Task.checkTaskDescription(taskDescription)) {
                System.out.println("Please enter a task description of less than 50 characters");
                taskDescription = scanner.nextLine();
            }
            System.out.println("Enter developer first name:");
            String devFirstName = scanner.nextLine();
            System.out.println("Enter developer last name:");
            String devLastName = scanner.nextLine();
            System.out.println("Enter task duration (in hours):");
            int taskDuration = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("Select task status (To Do, Doing, Done):");
            String taskStatus = scanner.nextLine();

            Task task = new Task(taskName, taskDescription, devFirstName, devLastName, taskDuration, taskStatus);
            tasks.add(task);
            System.out.println(task.printTaskDetails());
        }

        int totalHours = Task.returnTotalHours(tasks);
        System.out.println("Total number of hours: " + totalHours);
    }
}

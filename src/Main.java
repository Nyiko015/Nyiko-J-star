import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = null;

        // Registration loop
        while (login == null) {
            System.out.println("Register a new account:");
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            System.out.print("Enter first name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine();

            login = new Login(username, password, firstName, lastName);
            String registrationMessage = login.registerUser();
            System.out.println(registrationMessage);

            if (!registrationMessage.equals("User registered successfully.")) {
                login = null;
            }
        }

        // Login loop
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("Log in to your account:");
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            String loginStatus = login.returnLoginStatus(username, password);
            System.out.println(loginStatus);

            if (loginStatus.contains("Welcome")) {
                loggedIn = true;
            }
        }

        // Display welcome message
        System.out.println("Welcome to EasyKanban!");

        // Create an array to store tasks
        ArrayList<Task> tasks = new ArrayList<>();

        // Application loop
        boolean quit = false;
        while (!quit) {
            System.out.println("\n1) Add tasks\n2) Show report\n3) Quit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1: // Add tasks
                    System.out.print("How many tasks do you want to enter? ");
                    int numTasks = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    for (int i = 0; i < numTasks; i++) {
                        System.out.print("Enter task name: ");
                        String taskName = scanner.nextLine();

                        System.out.print("Enter task description: ");
                        String taskDescription = scanner.nextLine();

                        // Validate task description
                        if (taskDescription.length() > 50) {
                            System.out.println("Please enter a task description of less than 50 characters.");
                            i--; // Retry this task
                            continue;
                        }

                        System.out.print("Enter developer details: ");
                        String developerDetails = scanner.nextLine();

                        System.out.print("Enter task duration (in hours): ");
                        int taskDuration = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        System.out.println("Select task status:\n1) To Do\n2) Doing\n3) Done");
                        int statusOption = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        String taskStatus = switch (statusOption) {
                            case 1 -> "To Do";
                            case 2 -> "Doing";
                            case 3 -> "Done";
                            default -> "Unknown";
                        };

                        Task task = new Task(taskName, i, taskDescription, developerDetails, taskDuration, taskStatus);
                        tasks.add(task);

                        // Display task details
                        System.out.println(task.printTaskDetails());
                    }
                    break;

                case 2: // Show report
                    System.out.println("Coming Soon");
                    break;

                case 3: // Quit
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }
}

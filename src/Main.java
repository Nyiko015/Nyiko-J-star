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

            // If registration fails, reset the login object
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

            // If login is successful, exit the loop
            if (loginStatus.contains("Welcome")) {
                loggedIn = true;
            }
        }
    }
}

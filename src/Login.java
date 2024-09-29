public class Login {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    // Constructor to register user
    public Login(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Method to check username format
    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }

    // Method to check password complexity
    public boolean checkPasswordComplexity() {
        return password.length() >= 8 &&
               password.matches(".[A-Z].") &&
               password.matches(".[0-9].") &&
               password.matches(".[!@#$%^&()].*");
    }

    // Method to register user
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        } else if (!checkPasswordComplexity()) {
            return "Password does not meet the complexity requirements.";
        } else {
            return "User registered successfully.";
        }
    }

    // Method to verify login
    public boolean loginUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Method to return login status
    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
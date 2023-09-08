import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class ReminderApplication {

    // User authentication
    private static Map<String, String> users = new HashMap<>();
    private static String loggedInUser = null;

    public static boolean login(String username, String password) {
users.put("user1", "password1");
        if (users.containsKey(username) && users.get(username).equals(password)) {
            loggedInUser = username;
            return true;
        } else {
            return false;
        }
    }

    public static void logout() {
        loggedInUser = null;
    }

    // Reminder management
    private static List<Map<String, Object>> reminders = new ArrayList<>();

    public static void addReminder(String title, String date) {
        Map<String, Object> reminder = new HashMap<>();
        reminder.put("title", title);
        reminder.put("date", date);
        reminder.put("enabled", true);
        reminders.add(reminder);
    }

    public static void deleteReminder(String title) {
        reminders.removeIf(reminder -> reminder.get("title").equals(title));
    }

    public static void viewReminder(String title) {
        for (Map<String, Object> reminder : reminders) {
            if (reminder.get("title").equals(title)) {
                System.out.println("Title: " + reminder.get("title"));
                System.out.println("Date: " + reminder.get("date"));
                System.out.println("Enabled: " + reminder.get("enabled"));
            }
        }
    }

    public static void enableReminder(String title) {
        for (Map<String, Object> reminder : reminders) {
            if (reminder.get("title").equals(title)) {
                reminder.put("enabled", true);
            }
        }
    }

    public static void disableReminder(String title) {
        for (Map<String, Object> reminder : reminders) {
            if (reminder.get("title").equals(title)) {
                reminder.put("enabled", false);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nReminder Application Menu:");
            System.out.println("1. Login");
            System.out.println("2. Add Reminder");
            System.out.println("3. View Reminder");
            System.out.println("4. Delete Reminder");
            System.out.println("5. Enable Reminder");
            System.out.println("6. Disable Reminder");
            System.out.println("7. Logout");
            System.out.println("8. Quit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    if (loggedInUser != null) {
                        System.out.println("Already logged in as " + loggedInUser + ".");
                    } else {
                        System.out.print("Enter username: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String password = scanner.nextLine();
                        if (login(username, password)) {
                            System.out.println("Logged in as " + username + ".");
                        } else {
                            System.out.println("Login failed.");
                        }
                    }
                    break;

                case "2":
                    if (loggedInUser == null) {
                        System.out.println("Please login first.");
                    } else {
                        System.out.print("Enter reminder title: ");
                        String title = scanner.nextLine();
System.out.print("Enter reminder date: ");
                        String date = scanner.nextLine();
                        addReminder(title, date);
                        System.out.println("Reminder added.");
                    }
                    break;

                case "3":
                    if (loggedInUser == null) {
                        System.out.println("Please login first.");
                    } else {
                        System.out.print("Enter reminder title to View: ");
                        String title = scanner.nextLine();
                        viewReminder(title);
                        System.out.println("Reminder View.");
                    }
                    break;

                case "4":
                    if (loggedInUser == null) {
                        System.out.println("Please login first.");
                    } else {
                        System.out.print("Enter reminder title to delete: ");
                        String title = scanner.nextLine();
                        deleteReminder(title);
                        System.out.println("Reminder deleted.");
                    }
                    break;

                case "5":
                    if (loggedInUser == null) {
                        System.out.println("Please login first.");
                    } else {
                        System.out.print("Enter reminder title to enable: ");
                        String title = scanner.nextLine();
                        enableReminder(title);
                        System.out.println("Reminder enabled.");
                    }
                    break;

                case "6":
                    if (loggedInUser == null) {
                        System.out.println("Please login first.");
                    } else {
                        System.out.print("Enter reminder title to disable: ");
                        String title = scanner.nextLine();
                        disableReminder(title);
                        System.out.println("Reminder disabled.");
                    }
                    break;

                case "7":
                    logout();
                    System.out.println("Logged out.");
                    break;

                case "8":
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

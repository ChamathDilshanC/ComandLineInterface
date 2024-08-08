import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static String[][] students = new String[0][6];
    private static String[][] subjects = new String[0][2];
    private static String[][] marks = new String[0][3];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        students = new String[][]{
                {"1", "Chamath", "25", "0712345678", "123 Main St, Colombo", "2021"},
                {"2", "Kalpani", "23", "0771234567", "456 Park Ave, Kandy", "2021"},
                {"3", "Kalana", "22", "0751234567", "789 South St, Galle", "2021"}
        };
        subjects = new String[][]{
                {"1", "PRF"},
                {"2", "DBMS"},
                {"3", "OOP"}
        };
        marks = new String[][]{
                {"1", "1", "85"},
                {"1", "2", "90"},
                {"1", "3", "75"},
                {"2", "1", "80"},
                {"2", "2", "95"},
                {"2", "3", "70"},
                {"3", "1", "75"},
                {"3", "2", "85"},
                {"3", "3", "90"}
        };
        mainMenu();

    }

    private static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printHeader(String page) {
        clearConsole();
        System.out.println("\n\t\t\t\t\t\t\t\t+--------------------------------------------------------------------+");
        System.out.println("\t\t\t\t\t\t\t\t|     Welcome To  I J S E  Student Management " + page + " Page     |");
        System.out.println("\t\t\t\t\t\t\t\t+--------------------------------------------------------------------+");
        System.out.println();
    }

    private static void mainMenu() {
        while (true) {
            printHeader("System HOME");
            System.out.println("1) Manage Student");
            System.out.println("2) Manage Sub marks");
            System.out.println("3) Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    manageStudent();
                    break;
                case "2":
                    manageSubMarks();
                    break;
                case "3":
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageStudent() {
        while (true) {
            printHeader("STUDENT Management");
            System.out.println("1) Add new Student");
            System.out.println("2) Update Student");
            System.out.println("3) View Student");
            System.out.println("4) Main");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    updateStudent();
                    break;
                case "3":
                    viewStudent();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageSubMarks() {
        while (true) {
            printHeader("SUB MARKS Management");
            System.out.println("1) Add new subject");
            System.out.println("2) Add marks");
            System.out.println("3) Update marks");
            System.out.println("4) View Sub marks");
            System.out.println("5) Main");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addSubject();
                    break;
                case "2":
                    addMarks();
                    break;
                case "3":
                    updateMarks();
                    break;
                case "4":
                    viewSubMarks();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent() {
        printHeader("ADD Student");
        String[] student = new String[6];
        System.out.print("Enter Student ID: ");
        student[0] = scanner.nextLine();
        System.out.print("Enter Name: ");
        student[1] = scanner.nextLine();
        System.out.print("Enter Age: ");
        student[2] = scanner.nextLine();
        System.out.print("Enter Contact: ");
        student[3] = scanner.nextLine();
        System.out.print("Enter Address: ");
        student[4] = scanner.nextLine();
        System.out.print("Enter Batch: ");
        student[5] = scanner.nextLine();

        students = growArray(students, student);
        System.out.println("Student added successfully.");
    }

    private static void updateStudent() {
        printHeader("UPDATE Student");
        System.out.print("Enter Student ID to update: ");
        String sid = scanner.nextLine();
        for (int i = 0; i < students.length; i++) {
            if (students[i][0].equals(sid)) {
                System.out.println("Enter new details (press enter to keep current value):");

                System.out.print("Name (" + students[i][1] + "): ");
                String name = scanner.nextLine();
                if (!name.isEmpty()) students[i][1] = name;

                System.out.print("Age (" + students[i][2] + "): ");
                String age = scanner.nextLine();
                if (!age.isEmpty()) students[i][2] = age;

                System.out.print("Contact (" + students[i][3] + "): ");
                String contact = scanner.nextLine();
                if (!contact.isEmpty()) students[i][3] = contact;

                System.out.print("Address (" + students[i][4] + "): ");
                String address = scanner.nextLine();
                if (!address.isEmpty()) students[i][4] = address;

                System.out.print("Batch (" + students[i][5] + "): ");
                String batch = scanner.nextLine();
                if (!batch.isEmpty()) students[i][5] = batch;

                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void viewStudent() {
        printHeader("VIEW Student");
        if (students.length == 0) {
            System.out.println("No students found.");
            return;
        }

        // Print table headers
        System.out.printf("%-15s| %-20s| %-3s| %-15s| %-30s| %-10s%n",
                "Student ID", "Name", "Age", "Contact", "Address", "Batch");
        System.out.println("---------------+----------------------+-----+-----------------+--------------------------------+------------");

        // Print student details
        for (String[] student : students) {
            System.out.printf("%-15s| %-20s| %-3s| %-15s| %-30s| %-10s%n",
                    student[0], student[1], student[2], student[3], student[4], student[5]);
        }

        System.out.println();
        System.out.println("Do you want to go to Student Management Form? (Y/N)");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            manageStudent();
        } else {
            mainMenu();
        }
    }

    private static void addSubject() {
        printHeader("ADD Subject");
        String[] subject = new String[2];
        System.out.print("Enter Subject ID: ");
        subject[0] = scanner.nextLine();
        System.out.print("Enter Subject Name: ");
        subject[1] = scanner.nextLine();

        subjects = growArray(subjects, subject);
        System.out.println("Subject added successfully.");
    }

    private static void addMarks() {
        printHeader("ADD Marks");
        System.out.print("Enter Subject ID: ");
        String subId = scanner.nextLine();
        for (String[] subject : subjects) {
            if (subject[0].equals(subId)) {
                System.out.print("Enter Student ID: ");
                String sid = scanner.nextLine();
                for (String[] student : students) {
                    if (student[0].equals(sid)) {
                        System.out.print("Enter Marks: ");
                        String mark = scanner.nextLine();
                        String[] markEntry = {subId, sid, mark};
                        marks = growArray(marks, markEntry);
                        System.out.println("Marks added successfully.");
                        return;
                    }
                }
                System.out.println("Student not found.");
                return;
            }
        }
        System.out.println("Subject not found.");
    }

    private static void updateMarks() {
        printHeader("UPDATE Marks");
        System.out.print("Enter Subject ID: ");
        String subId = scanner.nextLine();
        for (int i = 0; i < marks.length; i++) {
            if (marks[i][0].equals(subId)) {
                System.out.print("Enter Student ID: ");
                String sid = scanner.nextLine();
                if (marks[i][1].equals(sid)) {
                    System.out.print("Enter new marks (current: " + marks[i][2] + "): ");
                    String newMarks = scanner.nextLine();
                    marks[i][2] = newMarks;
                    System.out.println("Marks updated successfully.");
                    return;
                }
                System.out.println("Marks not found for this student.");
                return;
            }
        }
        System.out.println("Subject not found.");
    }

    private static void viewSubMarks() {
        printHeader("VIEW Sub Marks");
        System.out.println();
        System.out.println("No. of Students: " + students.length);
        System.out.println("No. of Subjects: " + subjects.length);
        System.out.println();
        System.out.printf("%-10s | %-15s | %-10s | %-10s | %-15s | %-10s%n", "Id", "Name", "Batch", "Sub Id", "Sub Name", "Marks");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // Array to store total marks for each student
        int[][] studentTotals = new int[students.length][2]; // [0]: student index, [1]: total marks

        // Calculate total marks for each student
        for (int i = 0; i < students.length; i++) {
            String studentId = students[i][0];
            int totalMarks = 0;

            for (String[] mark : marks) {
                if (mark[1].equals(studentId)) {
                    totalMarks += Integer.parseInt(mark[2]);
                }
            }
            studentTotals[i][0] = i;
            studentTotals[i][1] = totalMarks;
        }

        // Sort students by total marks in descending order to determine places
        java.util.Arrays.sort(studentTotals, (a, b) -> Integer.compare(b[1], a[1]));

        // Create an array to store the place of each student
        int[] studentPlaces = new int[students.length];
        for (int i = 0; i < studentTotals.length; i++) {
            studentPlaces[studentTotals[i][0]] = i + 1;
        }

        // Iterate through students to display their marks and places
        for (int i = 0; i < students.length; i++) {
            String studentId = students[i][0];
            String studentName = students[i][1];
            String studentBatch = students[i][5];

            int totalMarks = 0;
            int subjectCount = 0;

            boolean firstPrint = true; // Flag to print student details only once

            for (String[] subject : subjects) {
                String subjectId = subject[0];
                String subjectName = subject[1];

                boolean hasMarks = false;
                for (String[] mark : marks) {
                    if (mark[0].equals(subjectId) && mark[1].equals(studentId)) {
                        int subjectMarks = Integer.parseInt(mark[2]);
                        totalMarks += subjectMarks;
                        subjectCount++;
                        hasMarks = true;

                        if (firstPrint) {
                            System.out.printf("%-10s | %-15s | %-10s | %-10s | %-15s | %-10d%n",
                                    studentId, studentName, studentBatch, subjectId, subjectName, subjectMarks);
                            firstPrint = false;
                        } else {
                            System.out.printf("%-10s | %-15s | %-10s | %-10s | %-15s | %-10d%n",
                                    "", "", "", subjectId, subjectName, subjectMarks);
                        }
                    }
                }

                if (!hasMarks) {
                    if (firstPrint) {
                        System.out.printf("%-10s | %-15s | %-10s | %-10s | %-15s  | %-10d%n",
                                studentId, studentName, studentBatch, subjectId, subjectName, "N/A");
                        firstPrint = false;
                    } else {
                        System.out.printf("%-10s | %-15s | %-10s | %-10s | %-15s | %-10s%n",
                                "", "", "", subjectId, subjectName, "N/A");
                    }
                }
            }

            if (subjectCount > 0) {
                System.out.printf("%-10s | %-15s | %-10s | %-10s | %-15s | %-10s | %-10d%n", "", "", "", "Total", "", "", totalMarks);
                System.out.printf("%-10s | %-15s | %-10s | %-10s | %-15s | %-10s | %-10.2f%n", "", "", "", "Average", "", "", totalMarks / (double) subjectCount);
                //places
                int studentPlace = studentPlaces[i];
                System.out.printf("%-10s | %-15s | %-10s | %-10s | %-15s | %-10s | %-10d%n", "", "", "", "Place", "", "", studentPlace);
                System.out.println();
                System.out.println("-----------------------------------------------------------------------------------------------------");
            } else {
                System.out.printf("%-10s | %-15s | %-10s | %-10s | %-15s | %-10s | %-10s%n", "", "", "", "Total", "", "", "N/A");
                System.out.printf("%-10s | %-15s | %-10s | %-10s | %-15s | %-10s | %-10s%n", "", "", "", "Average", "", "", "N/A");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Do you want to go to Sub Marks Management Form? (Y/N)");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            manageSubMarks();
        } else {
            mainMenu();
        }
    }

    private static String[][] growArray(String[][] array, String[] newElement) {
        String[][] newArray = new String[array.length + 1][];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = newElement;
        return newArray;
    }
}

import java.io.*;
import java.util.*;

public class StudentManagement {
    public static void main(String[] args) {
        LinkedList<Student> students = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter student name (or 'quit' to finish): ");
            String name = scanner.nextLine().trim();
            
            if (name.equalsIgnoreCase("quit")) {
                break;
            }
            
            System.out.print("Enter student address: ");
            String address = scanner.nextLine().trim();
            
            double gpa;
            while (true) {
                System.out.print("Enter student GPA (0.0-4.0): ");
                try {
                    gpa = Double.parseDouble(scanner.nextLine().trim());
                    if (gpa >= 0.0 && gpa <= 4.0) {
                        break;
                    } else {
                        System.out.println("Error: GPA must be between 0.0 and 4.0");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Please enter a valid number");
                }
            }
            
            students.add(new Student(name, address, gpa));
            System.out.println("Student added successfully!\n");
        }
        
        Collections.sort(students);

        try (PrintWriter writer = new PrintWriter("students.txt")) {
            writer.println("Student List (Sorted by Name)");
            writer.println("===========================\n");
            
            for (Student student : students) {
                writer.println(student.toString());
                writer.println("---------------------------");
            }
            
            System.out.println("\nStudent data has been written to students.txt");
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: Could not write to file");
            e.printStackTrace();
        }
        
        scanner.close();
    }
}
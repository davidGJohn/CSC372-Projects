import java.util.ArrayList;

public class StudentManagement {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(5, "Alice", "New York"));
        students.add(new Student(2, "Bob", "San Francisco"));
        students.add(new Student(9, "Charlie", "Chicago"));
        students.add(new Student(1, "David", "Raleigh"));
        students.add(new Student(7, "Eve", "Seattle"));
        students.add(new Student(3, "Frank", "Miami"));
        students.add(new Student(10, "Grace", "Dallas"));
        students.add(new Student(6, "Heidi", "Denver"));
        students.add(new Student(4, "Ivan", "Philadelphia"));
        students.add(new Student(8, "Julia", "Austin"));

        System.out.println("Original List:");
        students.forEach(System.out::println);
        
        System.out.println("\nSorted by Name:");
        CustomSorter.selectionSort(students, new NameComparator());
        students.forEach(System.out::println);
    
        System.out.println("\nSorted by Roll Number:");
        CustomSorter.selectionSort(students, new RollnoComparator());
        students.forEach(System.out::println);
    }
}


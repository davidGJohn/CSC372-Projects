public class Student implements Comparable<Student> {
    private String name;
    private String address;
    private double gpa;
    
    public Student(String name, String address, double gpa) {
        this.name = name;
        this.address = address;
        this.gpa = gpa;
    }
    
    public String getName() { return name; }
    public String getAddress() { return address; }
    public double getGPA() { return gpa; }
    
    @Override
    public int compareTo(Student other) {
        return this.name.compareToIgnoreCase(other.name);
    }
    
    @Override
    public String toString() {
        return String.format("Name: %s\nAddress: %s\nGPA: %.2f\n", name, address, gpa);
    }
}

import java.util.Scanner;

public class Student {
    // Data members
    private String studentName;
    private String rollNumber;
    private double marks;
    private String courseName;
    private int courseCredits;

    // Parameterized constructor
    public Student(String studentName, String rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Method to check registration eligibility
    public boolean checkEligibility() {
        return this.marks >= 50;
    }

    // Method to calculate base course fee (Rs. 1500 per credit)
    public double calculateFee() {
        return this.courseCredits * 1500.0;
    }

    // Method to calculate scholarship amount based on marks
    public double calculateScholarship() {
        double fee = calculateFee();
        if (this.marks >= 85) {
            return fee * 0.20; // 20% scholarship
        } else if (this.marks >= 70 && this.marks <= 84) {
            return fee * 0.10; // 10% scholarship
        } else {
            return 0.0;        // No scholarship
        }
    }

    // Method to calculate the final fee after deducting scholarship
    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    // Method to display all the details
    public void displayDetails() {
        System.out.println("Marks Obtained    : " + marks);
        System.out.println("Course Registered : " + courseName);
        System.out.println("Course Credits    : " + courseCredits);
        System.out.println("Eligibility Status: Eligible");
        System.out.println("Total Course Fee  : Rs. " + calculateFee());
        System.out.println("Scholarship Avail : Rs. " + calculateScholarship());
        System.out.println("Final Fee to Pay  : Rs. " + calculateFinalFee());
    }

    // The main method is now directly inside the Student class
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        String roll = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine(); // Consume newline

        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();

        System.out.print("Enter Course Credits: ");
        int credits = sc.nextInt();

        // Create Student object
        Student student = new Student(name, roll, marks, course, credits);

        // Check eligibility and execute operations
        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("Registration Failed: Student is not eligible for registration.");
        }

        sc.close();
    }
}

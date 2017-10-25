import java.util.*;

public class Program {

    // Creating a collection (basically a mutable(changeable) list) of courses the student takes
    static HashSet<Course> courses = new HashSet<>();

    // Creating the variables for the students information

    public static void main(String[] args) {

        int numberOfCoursesTaken;
        String firstName, lastName, majorDegree;

        System.out.println("Hello, Welcome to the GPA calculator\nPlease enter your first name");
        Scanner in = new Scanner(System.in);
        firstName = in.next();

        System.out.println("Please enter your last name.");
        lastName=in.next();

        System.out.println("What is your Major?");
        majorDegree= in.next();

        System.out.println("How many courses are you taking this semester?");
        numberOfCoursesTaken = in.nextInt();

        for (int i = 1; i <= numberOfCoursesTaken; i++) {
            System.out.println("Please enter the course number for course "+i);
            String courseNumber = in.next();
            System.out.println("How many credits was course "+i+" worth?");
            float creditValue = in.nextFloat();
            System.out.println("Based on the following scale for quality points :\n A 4.00 A- 3.67 \n B+ 3.33 B 3.00 B- 2.67 \n C+ 2.33 C 2.00 C- 1.67 \n D+ 1.33 D 1.00 \n F 0.00 \n Please enter exactly how many Quality points you received for your first class based on the chart above.");
            float qualityPoints = in.nextFloat();
            Course course = new Course(courseNumber,creditValue,qualityPoints);
            courses.add(course);
        }

        // Creating a collection of quality points(qualityPoints) from all your courses. NOTE : I use a list here and not a set because lists can contain duplicates and it is possible to have two of the same quality scores.
        ArrayList<Float> qualityPoints = new ArrayList<>();
        courses.forEach(course -> qualityPoints.add(course.qualityPoints));

        // Generating the sum of quality points
        Float sumOfQualityPoints = 0.0f;

        for (Float qualityPoint : qualityPoints) {
            sumOfQualityPoints += qualityPoint;
        }

        // Creating a collection of total course credits
        ArrayList<Float> courseCredits = new ArrayList<>();
        courses.forEach(course -> courseCredits.add(course.creditValue));

        Float sumOfCourseCredits = 0.0f;
        for (Float courseCredit : courseCredits) {
            sumOfCourseCredits += courseCredit;
        }

        Float gpa = sumOfQualityPoints / sumOfCourseCredits;

        System.out.println("Your GPA is : "+gpa);

    }


}

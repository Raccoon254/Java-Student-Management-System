import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        Student student = new Student("Steve","steve@java.com","07678","Eb3/49090/30");
        Course course = new Course("ACSC");
        Book book = new Book("Into The Badlands","2nd","V 0.0.2");
        Score score = new Score("Acs 234","Introduction to networks",60,'C',80,'B');
        //>>>>
        student.addBook(book);
        student.addToDatabase(student);
        student.enrollCourse(course);
        if (student.borrowBook(book)) {
            System.out.println("BorrowBook Success");
        } else {
            System.out.println("BorrowBook Failed");
        }
        if (student.returnBook(book)) {
            System.out.println("Return Book Success");
        }else {
            System.out.println("Return Fail");
        }
        Score returnedData = student.getResultSlip(score).get(0);
        System.out.println(returnedData.courseCode + " "+ returnedData.title +" "+returnedData.score);
        //System.out.println(student.getResultSlip(score).get(0));
    }
}

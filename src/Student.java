import java.sql.SQLException;
import java.util.ArrayList;

public class Student extends Person{
    Database database = new Database();
    private String regNumber;
    public Student(String name, String email, String phoneNumber, String regNumber) throws SQLException {
        super(name,email,phoneNumber);
        this.regNumber = regNumber;

    }

    public void addToDatabase(Student student) throws SQLException {
        database.addStudent(student);
    }

    public String getRegNumber() {
        return regNumber;
    }

    Boolean enrollCourse(Course course){
        String currentName = getName();
        database.addCourse(currentName,course);
        return true;
    }

    Boolean borrowBook(Book book){
        Book found = database.searchBook(book);
        if (found==null) {
            System.out.println("Book Unavailable");
        }
        database.borrowBook(book);
        return true;
    }

    Boolean returnBook(Book book){
        database.returnBook(book);
        return true;
    }

    public ArrayList<Score> getResultSlip(Score score){
        database.addDataToResultSlip(score);
        return database.getResultSlip();
    }

    public void addBook(Book book){
        database.addBook(book);
    }
}

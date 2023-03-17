import java.sql.SQLException;
import java.util.ArrayList;

public class Lecturer extends Person{
    private String staffId;
    Database database;

    {
        try {
            database = new Database();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Lecturer(String name, String email, String phoneNumber, String staffId){
        super(name,email,phoneNumber);
        this.staffId = staffId;
    }

    public void allocateCourses(Course course,Student student){
        database.recordStudentWithCourses(course,student);
    }

    public ArrayList<ArrayList<Student>> displayAllocated(){
       return database.getCourseStudentList();
    }
}

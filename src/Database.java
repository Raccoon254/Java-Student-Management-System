import java.sql.*;
import java.util.ArrayList;

public class Database {
    ArrayList<Course> courseList= new ArrayList<>();
    ArrayList<Book> bookList= new ArrayList<>();
    ArrayList<Book> borrowedBooks= new ArrayList<>();
    ArrayList<Score> resultSlip = new ArrayList<>();
    ArrayList<ArrayList<Student>> courseStudentList = new ArrayList<>();
    public Database() throws SQLException {

    }
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");

    public void recordStudentWithCourses(Course course, Student student){
        ArrayList<Student> currentStudent = new ArrayList<>();
        currentStudent.add(student);
        courseStudentList.add(1,currentStudent);
    }

    public void addStudent(Student student) throws SQLException {

        String query = "INSERT INTO `students`(`name`, `email`, `phone`, `reg`) VALUES ('"+student.getName()+"','"+student.getEmail()+"','"+student.getPhoneNumber()+"','"+student.getRegNumber()+"')";
        ResultSet resultSet;
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public ArrayList<ArrayList<Student>> getCourseStudentList() {
        return courseStudentList;
    }

    public void addDataToResultSlip(Score score){
        resultSlip.add(score);
    }
    public ArrayList<Score> getResultSlip() {
        return resultSlip;
    }

    public void addCourse(String name, Course course){
        courseList.add(course);
    }

    public ArrayList<Course> getCourses(){
        return courseList;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public Book searchBook(Book book){
        boolean found = false;
        for(Book row : bookList){
            if (row.equals(book)) {
                found=true;
                return book;
            }
        }
        return null;
    }

    public void addBook(Book book){
        bookList.add(book);
    }

    public void borrowBook(Book book) {
        Book foundBook = null;
        for (Book row : bookList) {
            if (row.equals(book)) {
                foundBook = row;
                break;
            }
        }
        if (foundBook != null) {
            borrowedBooks.add(foundBook);
            bookList.remove(foundBook);
        }
    }


    public void returnBook(Book book){
        borrowedBooks.remove(book);
        bookList.add(book);
    }

}

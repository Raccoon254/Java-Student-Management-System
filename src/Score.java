public class Score {
    String courseCode;
    String title;
    int score;
    char grade;
    int averageScore;
    char averageGrade;
    public Score(String courseCode, String title , int score, char grade, int averageScore, char averageGrade){
        //each course’s code, title, score and grade and average and average grade
        this.averageGrade=averageGrade;
        this.averageScore=averageScore;
        this.score=score;
        this.grade=grade;
        this.courseCode=courseCode;
        this.title= title;
    }

}

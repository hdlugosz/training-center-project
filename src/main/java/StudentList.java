import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StudentList {
    List<Student> students = new ArrayList<>();

    public StudentList() {
        Student student1 = new Student("Ivanov Ivan", "Java Developer",
                LocalDateTime.of(2021, 9, 6, 10, 0));
        student1.courseMap.put("Java", 18);
        student1.courseMap.put("JDBC", 14);
        student1.courseMap.put("Spring", 14);

        students.add(student1);

        Student student2 = new Student("Sidorov Ivan", "AQE",
                LocalDateTime.of(2021, 9, 7, 10, 0));
        student2.courseMap.put("Test Design", 3);
        student2.courseMap.put("Page Object", 2);
        student2.courseMap.put("Selenium", 1);

        students.add(student2);
    }
}

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

    /**
     * loadData method returns List of Student class that contains students data that is hardcoded.
     */
    public static List<Student> loadData() {
        List<Student> students = new ArrayList<>();

        Student student1 = new Student("Ivanov Ivan", "Java Developer",
                LocalDateTime.of(2021, 9, 6, 10, 0));
        student1.getCourseMap().put("Java", 28);
        student1.getCourseMap().put("JDBC", 14);
        student1.getCourseMap().put("Spring", 14);

        students.add(student1);

        Student student2 = new Student("Sidorov Ivan", "AQE",
                LocalDateTime.of(2021, 9, 7, 10, 0));
        student2.getCourseMap().put("Test Design", 3);
        student2.getCourseMap().put("Page Object", 2);
        student2.getCourseMap().put("Selenium", 1);

        students.add(student2);

        Student student3 = new Student("Leonardo DiCaprio", "Data Science",
                LocalDateTime.of(2021, 9, 1, 10, 0));
        student3.getCourseMap().put("Python", 4);
        student3.getCourseMap().put("R course", 4);
        student3.getCourseMap().put("MatLab", 4);

        students.add(student3);

        return students;
    }
}

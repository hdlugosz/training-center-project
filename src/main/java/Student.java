import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Student class contains students name and data about the course, start date of the course etc.
 */
public class Student {
    private String name;
    private String curriculum;
    private LocalDateTime startDateTime;
    private Map<String, Integer> courseMap;

    public Student(String name, String curriculum, LocalDateTime startDateTime) {
        this.name = name;
        this.curriculum = curriculum;
        this.startDateTime = startDateTime;
        courseMap = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Map<String, Integer> getCourseMap() {
        return courseMap;
    }

    public void setCourseMap(Map<String, Integer> courseMap) {
        this.courseMap = courseMap;
    }
}

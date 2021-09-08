import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class Student {
    String name;
    String curriculum;
    LocalDateTime startDateTime;
    Map<String, Integer> courseMap;

    public Student(String name, String curriculum, LocalDateTime startDateTime) {
        this.name = name;
        this.curriculum = curriculum;
        this.startDateTime = startDateTime;
        courseMap = new LinkedHashMap<>();
    }
}

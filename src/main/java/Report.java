import java.util.List;
import java.util.Map;

/**
 * Report class retrieves information about students from List<Student>
 * and is able to generate reports based on this information.
 */
public class Report {
    private final List<Student> students;

    public Report(List<Student> students) {
        this.students = students;
    }

    /**
     * generateShortReport returns short, sketchy information - one line per student.
     */
    public void generateShortReport() {

        for (Student student : students) {
            System.out.printf("%s(%s) - ", student.name, student.curriculum);

            int programDuration = 0;
            for (Map.Entry<String, Integer> entry : student.courseMap.entrySet()) {
                programDuration += entry.getValue();
            }

            int days;
            if (TrainingTimeManager.isTrainingFinished(student.startDateTime, programDuration)) {
                System.out.print("Training completed - ");
                int hoursAfterCompletion = (TrainingTimeManager.calculateHoursToTrainingCompletion(
                        student.startDateTime, programDuration));

                if (hoursAfterCompletion < 8) {
                    System.out.printf("Time passed since completion: %dhrs\n", hoursAfterCompletion);
                } else {
                    days = 0;
                    while (hoursAfterCompletion >= 8) {
                        days++;
                        hoursAfterCompletion -= 8;
                    }
                    System.out.printf("Time passed since completion: %dd %dhrs\n", days, hoursAfterCompletion);
                }

            } else {
                System.out.print("Training still in progress - ");
                int hoursToCompletion = TrainingTimeManager.calculateHoursToTrainingCompletion(
                        student.startDateTime, programDuration);

                if (hoursToCompletion < 8) {
                    System.out.printf("Time left to completion: %dhrs\n", hoursToCompletion);
                } else {
                    days = 0;
                    while (hoursToCompletion >= 8) {
                        days++;
                        hoursToCompletion -= 8;
                    }
                    System.out.printf("Time left to completion: %dd %dhrs\n", days, hoursToCompletion);
                }
            }
        }
        System.out.println("\n");
    }

    /**
     * generateFullReport returns complete, formatted information about each student.
     */
    public void generateFullReport() {

        for (Student student : students) {
            System.out.printf("Name: %32s\n", student.name);
            System.out.printf("Curriculum: %26s\n", student.curriculum);

            int programDuration = 0;
            for (Map.Entry<String, Integer> entry : student.courseMap.entrySet()) {
                System.out.printf("Course: %12s, Duration: %3dhrs\n", entry.getKey(), entry.getValue());
                programDuration += entry.getValue();
            }

            System.out.printf("Start date: %26s\n", student.startDateTime.toString());
            System.out.printf("End date: %28s\n", TrainingTimeManager.calculateEndDateTime(
                    student.startDateTime, programDuration).toString());

            int days = 0;
            int programDurationTemp = programDuration;
            if (programDurationTemp < 8) {
                System.out.printf("Duration of the program: %10dhrs\n", programDurationTemp);
            } else {
                while (programDurationTemp >= 8) {
                    days++;
                    programDurationTemp -= 8;
                }
                System.out.printf("Duration of the program: %7dd %dhrs\n", days, programDurationTemp);
            }

            if (TrainingTimeManager.isTrainingFinished(student.startDateTime, programDuration)) {
                int hoursAfterCompletion = (TrainingTimeManager.calculateHoursToTrainingCompletion(
                        student.startDateTime, programDuration));

                if (hoursAfterCompletion < 8) {
                    System.out.printf("Time passed since completion: %5dhrs\n", hoursAfterCompletion);
                } else {
                    days = 0;
                    while (hoursAfterCompletion >= 8) {
                        days++;
                        hoursAfterCompletion -= 8;
                    }
                    System.out.printf("Time passed since completion: %2dd %dhrs\n", days, hoursAfterCompletion);
                }

            } else {
                int hoursToCompletion = TrainingTimeManager.calculateHoursToTrainingCompletion(
                        student.startDateTime, programDuration);

                if (hoursToCompletion < 8) {
                    System.out.printf("Time left to completion: %10dhrs\n", hoursToCompletion);
                } else {
                    days = 0;
                    while (hoursToCompletion >= 8) {
                        days++;
                        hoursToCompletion -= 8;
                    }
                    System.out.printf("Time left to completion: %7dd %dhrs\n", days, hoursToCompletion);
                }
            }
            System.out.println("\n");
        }
    }
}

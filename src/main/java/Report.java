import java.util.Map;

public class Report {
    private final StudentList list;

    public Report(StudentList list) {
        this.list = list;
    }

    public void generateShortReport() {

        for (int i = 0; i < list.students.size(); i++) {
            System.out.printf("%s(%s) - ", list.students.get(i).name, list.students.get(i).curriculum);

            int programDuration = 0;
            for (Map.Entry<String, Integer> entry : list.students.get(i).courseMap.entrySet()) {
                programDuration += entry.getValue();
            }

            int days;
            if (DateTimeManager.isTrainingFinished(list.students.get(i).startDateTime, programDuration)) {
                System.out.print("Training completed - ");
                int hoursAfterCompletion = (DateTimeManager.calculateHoursToTrainingCompletion(
                        list.students.get(i).startDateTime, programDuration));

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
                int hoursToCompletion = DateTimeManager.calculateHoursToTrainingCompletion(
                        list.students.get(i).startDateTime, programDuration);

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

    public void generateFullReport() {

        for (int i = 0; i < list.students.size(); i++) {
            System.out.printf("Name: %32s\n", list.students.get(i).name);
            System.out.printf("Curriculum: %26s\n", list.students.get(i).curriculum);

            int programDuration = 0;
            for (Map.Entry<String, Integer> entry : list.students.get(i).courseMap.entrySet()) {
                System.out.printf("Course: %12s, Duration: %3dhrs\n", entry.getKey(), entry.getValue());
                programDuration += entry.getValue();
            }

            System.out.printf("Start date: %26s\n", list.students.get(i).startDateTime.toString());

            System.out.printf("End date: %28s\n", DateTimeManager.calculateEndDateTime(
                    list.students.get(i).startDateTime, programDuration).toString());

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

            if (DateTimeManager.isTrainingFinished(list.students.get(i).startDateTime, programDuration)) {
                int hoursAfterCompletion = (DateTimeManager.calculateHoursToTrainingCompletion(
                        list.students.get(i).startDateTime, programDuration));

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
                int hoursToCompletion = DateTimeManager.calculateHoursToTrainingCompletion(
                        list.students.get(i).startDateTime, programDuration);

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

import java.util.List;

public class ReportRunner {

    public static void main(String[] args) {

        /* Loading hardcoded data to List<Student> using loadData(). */
        List<Student> students = DataLoader.loadData();

        /* Initializing Report object using loaded data. */
        Report report = new Report(students);

        /* Zero arguments or argument "0" in cmd -> short report, otherwise -> full report. */
        if (args.length == 0 || args[0].equals("0")) {
            report.generateShortReport();
        } else {
            report.generateFullReport();
        }
    }
}

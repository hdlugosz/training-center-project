import java.util.List;

public class ReportRunner {

    public static void main(String[] args) {
        // Loading hardcoded data to List<Student> using loadData()
        List<Student> students = DataLoader.loadData();

        // Initializing Report object using loaded data
        Report report = new Report(students);

        // zero arguments or argument "0" in cmd -> short report
        // otherwise -> full report
        if (args.length == 0 || args[0].equals("0")) {
            report.generateShortReport();
        } else {
            report.generateFullReport();
        }
    }
}

/*
example output (10.09.2021 12:42):
% java ReportRunner 0
Ivanov Ivan(Java Developer) - Training still in progress - Time left to completion: 2d 6hrs
Sidorov Ivan(AQE) - Training completed - Time passed since completion: 2d 4hrs
Leonardo DiCaprio(Data Science) - Training completed - Time passed since completion: 5d 6hrs
 */

/*
example output (10.09.2021 12:42):
% java ReportRunner 1
Name:                      Ivanov Ivan
Curriculum:             Java Developer
Course:         Java, Duration:  28hrs
Course:         JDBC, Duration:  14hrs
Course:       Spring, Duration:  14hrs
Start date:           2021-09-06T10:00
End date:             2021-09-14T18:00
Duration of the program:       7d 0hrs
Time left to completion:       2d 6hrs


Name:                     Sidorov Ivan
Curriculum:                        AQE
Course:  Test Design, Duration:   3hrs
Course:  Page Object, Duration:   2hrs
Course:     Selenium, Duration:   1hrs
Start date:           2021-09-07T10:00
End date:             2021-09-07T16:00
Duration of the program:          6hrs
Time passed since completion:  2d 4hrs


Name:                Leonardo DiCaprio
Curriculum:               Data Science
Course:       Python, Duration:   4hrs
Course:     R course, Duration:   4hrs
Course:       MatLab, Duration:   4hrs
Start date:           2021-09-01T10:00
End date:             2021-09-02T14:00
Duration of the program:       1d 4hrs
Time passed since completion:  5d 6hrs
 */

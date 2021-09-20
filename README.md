# Training Center Project
A simple program that generates reports containing information about students and the courses they attend at the training center.
For detailed instructions and requirements, see the Instructions.txt file.
Written in Java, built with maven, tests performed using Junit.

## Usage
To generate short reports, run the program without parameters or with the parameter `0`:

`% java ReportRunner` or `% java ReportRunner 0`

To generate full reports, run the program with any other parameter, for example `1`:

`% java ReportRunner 1`

## Example outputs:

Example output - short reports - 10.09.2021 12:42:

```
% java ReportRunner 0
Ivanov Ivan(Java Developer) - Training still in progress - Time left to completion: 2d 6hrs
Sidorov Ivan(AQE) - Training completed - Time passed since completion: 2d 4hrs
Leonardo DiCaprio(Data Science) - Training completed - Time passed since completion: 5d 6hrs
```

Example output - full reports - 10.09.2021 12:42:

```
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
```

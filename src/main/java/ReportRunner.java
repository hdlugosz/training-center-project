/*
Add comments
Add tests
Add possibility to change date(?)
Add possibility to override current date for tests
fill array with students or smt like that
add example output in comment

Don't know what does "The date of the launch option is carried out by the input parameter." mean
Don't know if the way I implemented StudentList is right
Don't know if the whole structure of the program is right
 */

public class ReportRunner {

    public static void main(String[] args) {
        StudentList list = new StudentList();
        Report report = new Report(list);

        if(args.length == 0 || args[0].equals("0")){
            report.generateShortReport();
        }
        else{
            report.generateFullReport();
        }
    }
}

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TrainingTimeManager {

    /**
     * calculateHoursBetweenTwoDateTimes method calculates and returns number of hours between two given dates,
     * taking into account the weekends and the fact that working hours are between 10 and 18.
     */
    public static int calculateHoursBetweenTwoDateTimes(LocalDateTime earlierDateTime, LocalDateTime laterDateTime) {

        int hours = 0;

        if (earlierDateTime.getHour() == 18) {
            earlierDateTime = earlierDateTime.plusHours(16);
        }

        while (earlierDateTime.isBefore(laterDateTime)) {
            if (earlierDateTime.getHour() >= 10 && earlierDateTime.getHour() <= 17 &&
                    earlierDateTime.getDayOfWeek() != DayOfWeek.SATURDAY &&
                    earlierDateTime.getDayOfWeek() != DayOfWeek.SUNDAY) {
                earlierDateTime = earlierDateTime.plusHours(1);
                hours += 1;
            } else {
                earlierDateTime = earlierDateTime.plusHours(1);
            }
        }

        return hours;
    }

    /**
     * calculateEndDateTime method calculates and returns the end date of the course knowing the start date and
     * duration in hours, taking into account the weekends and the fact that working hours are between 10 and 18.
     */
    public static LocalDateTime calculateEndDateTime(LocalDateTime startDateTime, Integer programDuration) {

        while (programDuration > 8) {
            if (startDateTime.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    startDateTime.getDayOfWeek() == DayOfWeek.SUNDAY) {
                startDateTime = startDateTime.plusDays(1);
            } else {
                startDateTime = startDateTime.plusDays(1);
                programDuration -= 8;
            }
        }

        while (startDateTime.getDayOfWeek() == DayOfWeek.SATURDAY ||
                startDateTime.getDayOfWeek() == DayOfWeek.SUNDAY) {
            startDateTime = startDateTime.plusDays(1);
        }

        if (programDuration > 0) {
            startDateTime = startDateTime.plusHours(programDuration);
        }

        return startDateTime;
    }

    /**
     * isTrainingFinished method returns a boolean value depending on whether the course is finished or not.
     */
    public static boolean isTrainingFinished(LocalDateTime startDateTime, Integer programDuration) {

        LocalDateTime endDateTime = calculateEndDateTime(startDateTime, programDuration);
        LocalDateTime currentDateTime = calculateCurrentTime();

        return endDateTime.isBefore(currentDateTime) || endDateTime.isEqual(currentDateTime);
    }


    /**
     * calculateHoursToTrainingCompletion calculates and returns amount of hours from now until
     * the end date of the course (both, remaining to completion or passed from completion).
     */
    public static int calculateHoursToTrainingCompletion(LocalDateTime startDateTime, Integer programDuration) {

        LocalDateTime endDateTime = calculateEndDateTime(startDateTime, programDuration);
        LocalDateTime currentDateTime = calculateCurrentTime();

        LocalDateTime earlierDateTime;
        LocalDateTime laterDateTime;

        if (isTrainingFinished(startDateTime, programDuration)) {
            earlierDateTime = endDateTime;
            laterDateTime = currentDateTime;
        } else {
            earlierDateTime = currentDateTime;
            laterDateTime = endDateTime;
        }

        return calculateHoursBetweenTwoDateTimes(earlierDateTime, laterDateTime);
    }

    public static LocalDateTime calculateCurrentTime() {
        return LocalDateTime.now().truncatedTo(ChronoUnit.HOURS);
    }
}

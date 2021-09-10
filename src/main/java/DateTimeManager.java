import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
public class DateTimeManager {

    public static int calculateHoursBetweenTwoDateTimes(LocalDateTime earlierDateTime, LocalDateTime laterDateTime) {

        int hours = 0;

        if (earlierDateTime.getHour() == 18) {
            earlierDateTime = earlierDateTime.plusHours(16);
        }

        while (earlierDateTime.isBefore(laterDateTime)) {
            if (earlierDateTime.getHour() >= 10 && earlierDateTime.getHour() <= 17 &&
                    !Objects.equals(earlierDateTime.getDayOfWeek().toString(), "SATURDAY") &&
                    !Objects.equals(earlierDateTime.getDayOfWeek().toString(), "SUNDAY")) {
                earlierDateTime = earlierDateTime.plusHours(1);
                hours += 1;
            } else {
                earlierDateTime = earlierDateTime.plusHours(1);
            }
        }

        return hours;
    }

    public static LocalDateTime calculateEndDateTime(LocalDateTime startDateTime, Integer programDuration) {

        while (programDuration > 8) {
            if (Objects.equals(startDateTime.getDayOfWeek().toString(), "SATURDAY") ||
                    Objects.equals(startDateTime.getDayOfWeek().toString(), "SUNDAY")) {
                startDateTime = startDateTime.plusDays(1);
            } else {
                startDateTime = startDateTime.plusDays(1);
                programDuration -= 8;
            }
        }

        while (Objects.equals(startDateTime.getDayOfWeek().toString(), "SATURDAY") ||
                Objects.equals(startDateTime.getDayOfWeek().toString(), "SUNDAY")) {
            startDateTime = startDateTime.plusDays(1);
        }

        if (programDuration > 0) {
            startDateTime = startDateTime.plusHours(programDuration);
        }

        return startDateTime;
    }

    public static boolean isTrainingFinished(LocalDateTime startDateTime, Integer programDuration) {

        LocalDateTime endDateTime = calculateEndDateTime(startDateTime, programDuration);
        LocalDateTime currentDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.HOURS);

        return endDateTime.isBefore(currentDateTime) || endDateTime.isEqual(currentDateTime);
    }

    public static int calculateHoursToTrainingCompletion(LocalDateTime startDateTime, Integer programDuration) {

        LocalDateTime endDateTime = calculateEndDateTime(startDateTime, programDuration);
        LocalDateTime currentDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.HOURS);

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
}

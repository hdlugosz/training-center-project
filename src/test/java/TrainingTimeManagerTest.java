import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class TrainingTimeManagerTest {

    /* calculateHoursBetweenTwoDateTimes method: */
    @Test
    public void calculateHoursBetweenTwoDateTimes_SameDayTimeDifference() {
        assertEquals(7, TrainingTimeManager.calculateHoursBetweenTwoDateTimes(
                LocalDateTime.of(2021, 9, 6, 10, 0),
                LocalDateTime.of(2021, 9, 6, 17, 0)
        ));
    }

    @Test
    public void calculateHoursBetweenTwoDateTimes_OutsideWorkingHours() {
        assertEquals(8, TrainingTimeManager.calculateHoursBetweenTwoDateTimes(
                LocalDateTime.of(2021, 9, 6, 7, 0),
                LocalDateTime.of(2021, 9, 6, 19, 0)
        ));
    }

    @Test
    public void calculateHoursBetweenTwoDateTimes_TwoSameDates() {
        assertEquals(0, TrainingTimeManager.calculateHoursBetweenTwoDateTimes(
                LocalDateTime.of(2021, 9, 6, 11, 0),
                LocalDateTime.of(2021, 9, 6, 11, 0)
        ));
    }

    @Test
    public void calculateHoursBetweenTwoDateTimes_DatesSeparatedByWeekend() {
        assertEquals(5, TrainingTimeManager.calculateHoursBetweenTwoDateTimes(
                LocalDateTime.of(2021, 9, 10, 15, 0),
                LocalDateTime.of(2021, 9, 13, 12, 0)
        ));
    }

    @Test
    public void calculateHoursBetweenTwoDateTimes_DatesSeparatedByNight() {
        assertEquals(8, TrainingTimeManager.calculateHoursBetweenTwoDateTimes(
                LocalDateTime.of(2021, 9, 9, 15, 0),
                LocalDateTime.of(2021, 9, 10, 15, 0)
        ));
    }

    /* calculateEndDateTime method: */
    @Test
    public void calculateEndDateTime_durationLessThanOneWorkingDay() {
        assertEquals(LocalDateTime.of(2021, 9, 9, 17, 0),
                TrainingTimeManager.calculateEndDateTime(
                        LocalDateTime.of(2021, 9, 9, 10, 0),
                        7
                ));
    }

    @Test
    public void calculateEndDateTime_durationLongerThanOneWorkingDay() {
        assertEquals(LocalDateTime.of(2021, 9, 10, 12, 0),
                TrainingTimeManager.calculateEndDateTime(
                        LocalDateTime.of(2021, 9, 9, 10, 0),
                        10
                ));
    }

    @Test
    public void calculateEndDateTime_durationLongerThanOneWorkingWeek() {
        assertEquals(LocalDateTime.of(2021, 9, 16, 15, 0),
                TrainingTimeManager.calculateEndDateTime(
                        LocalDateTime.of(2021, 9, 9, 10, 0),
                        45
                ));
    }

    @Test
    public void calculateEndDateTime_NegativeDuration() {
        assertEquals(LocalDateTime.of(2021, 9, 16, 10, 0),
                TrainingTimeManager.calculateEndDateTime(
                        LocalDateTime.of(2021, 9, 16, 10, 0),
                        -10
                ));
    }

    /* isTrainingFinished method: */
    @Test
    public void isTrainingFinished_Finished() {
        assertTrue(TrainingTimeManager.isTrainingFinished(
                LocalDateTime.of(2021, 9, 7, 10, 0),
                12
        ));
    }

    @Test
    public void isTrainingFinished_NotFinished() {
        assertFalse(TrainingTimeManager.isTrainingFinished(
                LocalDateTime.now(),
                12
        ));
    }
}

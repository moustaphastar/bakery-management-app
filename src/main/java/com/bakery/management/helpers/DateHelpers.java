package com.bakery.management.helpers;

import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/***
 * Provides helper methods for date operations.
 * @since 1.0
 * @author Moustapha Star
 */
public class DateHelpers {

    /***
     * DateTimeFormatter with UTC ZoneOffset.
     */
    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ISO_OFFSET_DATE_TIME.withZone(ZoneOffset.UTC);

    /***
     * Current date as LocalDate.
     */
    private static final OffsetDateTime NOW = OffsetDateTime
            .now(ZoneOffset.UTC);

    /***
     * Maximum distance allowed between two dates in total months.
     * An application wide rule related to date and time actions.
     */
    private static final int MAX_MONTH_DISTANCE = 3;

    /***
     * Earliest allowed date and time with UTC offset backwards.
     * First instant of the year which is 5 years before now.
     * An application wide rule related to date and time actions.
     */
    private static final OffsetDateTime MIN_INSTANT =
            OffsetDateTime.of(
                    NOW.getYear() - 5,
                    1, 1,
                    0,
                    0,
                    0,
                    0,
                    ZoneOffset.UTC);

    /***
     * State of validity of date parameters.
     * {@see validatePeriod} for validation rules.
     */
    private static boolean datesValidatedAndSorted = false;

    /***
     * Holds earlier date.
     */
    private OffsetDateTime earlierDate;

    /***
     * Holds later date.
     */
    private OffsetDateTime laterDate;

    /***
     * Constructor with two OffsetDateTime parameters.
     * @param date1 the date that is believed to be earlier
     * @param date2 the date that is believed to be later
     */
    public DateHelpers(final OffsetDateTime date1,
                       final OffsetDateTime date2) {
        this.earlierDate = date1;
        this.laterDate = date2;
        validateAndSortDates();
    }

    /***
     * Constructor with two String parameters.
     * @param date1 the date that is believed to be earlier
     * @param date2 the date that is believed to be later
     */
    public DateHelpers(final String date1, final String date2)
            throws DateTimeParseException, IllegalArgumentException {
        this(OffsetDateTime.parse(date1, DATE_TIME_FORMATTER),
                OffsetDateTime.parse(date2, DATE_TIME_FORMATTER));
    }

    /***
     * Parses a ISO 8061 formatted String into OffsetDateTime with UTC offset.
     * @param date ISO 8061 formatted date time with offset string
     * @return parsed OffsetDateTime object
     */
    // todo: formatter utc is to format output or to catch utc in input string?
    public static OffsetDateTime parse(final String date)
            throws DateTimeParseException {
        return OffsetDateTime.parse(date, DATE_TIME_FORMATTER);
    }

    /**
     * Checks if given two dates match three criteria.
     * 1st: dates are before {@see NOW}
     * 2nd: dates are after {@see MIN_INSTANT}
     * 3rd: distance of dates in months is not gt {@see MAX_MONTH_DISTANCE}
     */
    private void validateAndSortDates() throws IllegalArgumentException {
        // 1st criteria check.
        if (earlierDate.isAfter(NOW) || laterDate.isAfter(NOW)) {
            throw new IllegalArgumentException(
                    "A date cannot be later than now.");
        }

        // 2nd criteria check.
        if (earlierDate.isBefore(MIN_INSTANT)
                || laterDate.isBefore(MIN_INSTANT)) {
            throw new IllegalArgumentException(
                    "A date can't be before than " + MIN_INSTANT);
        }

        // 3rd criteria check.
        long period = Period
                .between(earlierDate.toLocalDate(), laterDate.toLocalDate())
                .toTotalMonths();

        // If dates provides in reverse order,
        if (period < 0) {
            // Reverse the dates.
            final OffsetDateTime tempDate = earlierDate;
            earlierDate = laterDate;
            laterDate = tempDate;
            // Absolute the period value.
            period = period * -1;
        }

        if (period < 0 || period > MAX_MONTH_DISTANCE) {
            throw new IllegalArgumentException(
                    "Distance between dates are gt "
                            + MAX_MONTH_DISTANCE + " months");
        }

        datesValidatedAndSorted = true;

    }

    /**
     * Returns the earlier OffsetDateTime if dates are validated and sorted.
     *
     * @return earlier date value or null
     * @see #datesValidatedAndSorted
     */
    public OffsetDateTime getEarlierDate() {
        if (datesValidatedAndSorted) {
            return earlierDate;
        }
        return null;
    }

    /**
     * Returns the earlier OffsetDateTime if dates are validated and sorted.
     *
     * @return later date value or null
     * @see #laterDate
     */
    public OffsetDateTime getLaterDate() {
        if (datesValidatedAndSorted) {
            return laterDate;
        }
        return null;
    }

}

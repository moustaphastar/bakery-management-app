package com.bakery.management.helpers;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

/***
 * Provides helper methods for date operations.
 * @since 1.0
 * @author Moustapha Star
 */
public class DateHelpers {

    /***
     * Current date as LocalDate.
     */
    // todo: LocalDateTime or LocalDate?
    private static final LocalDate CURRENT_DATE = LocalDate.now();

    /***
     * State of validity of date parameters.
     * {@see validatePeriod} for validation rules.
     */
    private static boolean isPeriodValid = false;

    /***
     * Holds beginning date.
     */
    private final LocalDate dateFrom;

    /***
     * Holds ending date.
     */
    private final LocalDate dateTo;

    /***
     * Holds beginning and ending dates in order.
     * First entry key is fromDate and second entry key is toDate.
     */
    private final Map<String, LocalDate> orderedMap = new HashMap<>(2);

    /***
     * Constructor with two date parameters.
     * @param dateOne the date that is believed to be earlier
     * @param dateTwo the date that is believed to be later
     */
    public DateHelpers(final LocalDate dateOne, final LocalDate dateTwo) {
        this.dateFrom = dateOne;
        this.dateTo = dateTwo;
    }

    /**
     * Checks if given two dates match those three criteria.
     * First: maximum distance allowed in total months between dates.
     * Second: maximum distance backwards from now.
     * Three: dates are before now.
     *
     * @param maxDistanceInMonths maximum distance allowed in total months
     * @return this
     */
    // todo: Add comparison for CURRENT_DATE.
    public DateHelpers validatePeriod(final int maxDistanceInMonths) {
        long period = Period.between(dateFrom, dateTo).toTotalMonths();

        if (dateFrom.isBefore(CURRENT_DATE)
                & dateTo.isBefore(CURRENT_DATE)
                & period <= maxDistanceInMonths) {
            isPeriodValid = true;
        }

        return this;
    }

    /**
     * Builds a Map containing ordered result if time period is valid,
     * otherwise returns null. fromDate is the earlier one. If dates
     * are equal then fromDate parameter is accepted the earlier one.
     *
     * @return this
     */
    public DateHelpers buildMap() {
        if (isPeriodValid) {
            if (dateFrom.isBefore(dateTo)) {
                orderedMap.put("fromDate", dateFrom);
                orderedMap.put("toDate", dateTo);
            } else {
                orderedMap.put("fromDate", dateTo);
                orderedMap.put("toDate", dateFrom);
            }
        }

        return this;
    }

    /**
     * Returns the value with fromDate key from {@link #orderedMap}.
     *
     * @return beginning date
     */
    public OffsetDateTime getFromDate() {
        if (isPeriodValid) {
            return orderedMap
                    .get("fromDate")
                    .atStartOfDay()
                    .atOffset(ZoneOffset.UTC);
        }
        return null;
    }

    /**
     * Returns the value with toDate key from {@link #orderedMap}.
     *
     * @return ending date
     */
    public OffsetDateTime getToDate() {
        if (isPeriodValid) {
            return orderedMap
                    .get("toDate")
                    .atStartOfDay()
                    .atOffset(ZoneOffset.UTC);
        }
        return null;
    }
}

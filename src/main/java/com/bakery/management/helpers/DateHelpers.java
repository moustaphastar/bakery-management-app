package com.bakery.management.helpers;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

public class DateHelpers {
    private static final LocalDate currentDate = LocalDate.now();
    private static boolean isPeriodValid = false;
    private final LocalDate dateOne;
    private final LocalDate dateTwo;
    private final Map<String, LocalDate> orderedMap = new HashMap<>(2);

    public DateHelpers(LocalDate dateOne, LocalDate dateTwo) {
        this.dateOne = dateOne;
        this.dateTwo = dateTwo;
    }

    /**
     * Checks if class Date members are earlier than current date
     * and the difference between in months equals to or less than
     * maxDistanceInMonths parameter.
     *
     * @param maxDistanceInMonths maximum distance in months between dates
     * @return this
     */
    public DateHelpers ValidatePeriod(int maxDistanceInMonths) {
        long period = Period.between(dateOne, dateTwo).toTotalMonths();

        if (dateOne.isAfter(currentDate) & dateTwo.isAfter(currentDate) & period >= maxDistanceInMonths) {
            isPeriodValid = true;
        }

        return this;
    }

    /**
     * Returns a HashMap containing ordered result if calculated period is valid.
     * Otherwise returns null. fromDate is the earlier one, toDate is the latter.
     * If dates are equal then dateOne parameter is accepted the earlier one.
     *
     * @return HashMap<String, Date>
     */
    public Map<String, LocalDate> GetMap() {
        if (isPeriodValid) {
            if (dateOne.isBefore(dateTwo)) {
                orderedMap.put("fromDate", dateOne);
                orderedMap.put("toDate", dateTwo);
            } else {
                orderedMap.put("fromDate", dateTwo);
                orderedMap.put("toDate", dateOne);
            }
        }

        return orderedMap;
    }
}

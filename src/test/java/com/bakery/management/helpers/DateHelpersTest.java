package com.bakery.management.helpers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.format.DateTimeParseException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DateHelpersTest {

    /***
     * Provides arguments with parameters for test methods.
     * An argument consists of two String parameters which delegates
     * earlier and later date parameters. Strings has valid ISO 8601
     * format such as 2020-06-18T19:03:41.695Z.
     *
     * @see DateHelpers
     * @return stream of arguments
     */
    private static Stream<Arguments> providePassingParameters() {
        return Stream.of(
                Arguments.of(
                        "2016-01-01T00:00:00+00:00",
                        "2016-01-01T19:03:41+00:00"),
                Arguments.of(
                        "2020-07-01T19:03:41+00:00",
                        "2020-05-01T19:03:41+00:00"),
                Arguments.of(
                        "2021-01-01T19:03:41+00:00",
                        "2021-02-11T07:48:00+03:00"),
                Arguments.of(
                        "2021-01-01T19:03:41+00:00",
                        "2021-01-01T07:48:41+03:00")
        );
    }

    /***
     * Provides arguments with parameters for test methods.
     * An argument consists of two String parameters which delegates
     * earlier and later date parameters. Strings has valid ISO 8601
     * format such as 2020-06-18T19:03:41.695Z.
     *
     * @see DateHelpers
     * @return stream of arguments
     */
    private static Stream<Arguments> provideFailingParameters() {
        return Stream.of(
                Arguments.of(
                        "2020 05-01T19:03:41+03:00",
                        "2020-09-01T19:03:41+03:00"),
                Arguments.of(
                        "2020-09-01T19:03:41+03:00",
                        "2020-05 01T19:03:41+03:00"),
                Arguments.of(
                        "2021-01-01T19:03:4103:00",
                        "2022-09-01T19:03:41+03:00"),
                Arguments.of(
                        "2015.12.31T23:59:59.999999999-00:00",
                        "2016-23-11T06:59:41-03:00")
        );
    }


    /***
     * Provides arguments with parameters for test methods.
     * An argument consists of two String parameters which delegates
     * earlier and later date parameters. Strings has valid ISO 8601
     * format such as 2020-06-18T19:03:41.695Z.
     *
     * @see DateHelpers
     * @return stream of arguments
     */
    private static Stream<Arguments> provideIllegalParameters() {
        return Stream.of(
                Arguments.of(
                        "2020-05-01T19:03:41+03:00",
                        "2020-09-01T19:03:41+03:00"),
                Arguments.of(
                        "2020-09-01T19:03:41+03:00",
                        "2020-05-01T19:03:41+03:00"),
                Arguments.of(
                        "2021-01-01T19:03:41+03:00",
                        "2022-09-01T19:03:41+03:00"),
                Arguments.of(
                        "2015-12-31T23:59:59.999999999-00:00",
                        "2016-12-11T06:59:41-03:00")
        );
    }

    /***
     * Provides arguments with parameters for test methods.
     * An argument consists of two String parameters which delegates
     * earlier and later date parameters. Strings has valid ISO 8601
     * format such as 2020-06-18T19:03:41.695Z.
     *
     * @see DateHelpers
     * @return stream of arguments
     */
    private static Stream<Arguments> getParametersForDateTimeParse() {
        return Stream.of(
                Arguments.of(
                        "2020-05-01T19:03:41+03:00",
                        "2020-09-01T19:03:41+03:00"),
                Arguments.of(
                        "2020-09-01T19:03:41+03:00",
                        "2020-05-01T19:03:41+03:00"),
                Arguments.of(
                        "2021-01-01T19:03:41+03:00",
                        "2022-09-01T19:03:41+03:00"),
                Arguments.of(
                        "2015-12-31T23:59:59.999999999-00:00",
                        "2016-02-11T06:59:41-03:00"),
                Arguments.of(
                        "2015-12-31T23:59:59.999999999+00:00",
                        "2016-02-11T06:59:41+03:00"),
                Arguments.of(
                        "2016-01-01T00:00:00+00:00",
                        "2016-02-11T06:59:41+03:00"),
                Arguments.of(
                        "2017-01-01T00:00:00+00:00",
                        "2017-02-11T06:59:41+03:00"),
                Arguments.of(
                        "2050-05-01T19:03:41+03:00",
                        "2050-07-01T19:03:41+03:00"),
                Arguments.of(
                        "+9999999999-12-31T23:59:59.999999999-18:00",
                        "-9999999999-01-01T00:00:00+18:00"),
                Arguments.of(
                        "+999999999-12-31T23:59:59.999999999-18:00",
                        "-999999999-01-01T00:00:00+18:00"),
                Arguments.of(
                        "-999999999-01-01T00:00:00.000000001+18:00",
                        "-999999999-01-01T00:00:00+18:00")
        );
    }


    /***
     * Should return OffsetDateTime object if string has valid ISO 8601 format.
     *
     * @see DateHelpers#parse(String)
     * @param d ISO8016 formatted string of a date time with offset
     */
    @ParameterizedTest
    @ValueSource(strings = {
            "2020-06-18T19:03:41.695Z",
            "2021-02-11T00:48:55+00:00",
            "2021-02-11T00:48:55Z"})
    // "20210211T004855Z" is a valid format but needs a custom format builder.
    public void parseShouldReturnOffsetDateTimeObject(final String d) {

        assertDoesNotThrow(() -> DateHelpers.parse(d));
    }

    /***
     * Should throw DateTimeParseException if string has non ISO 8601 format.
     *
     * @see DateHelpers#parse(String)
     * @param d non ISO 8601 date time string
     */
    @ParameterizedTest
    @ValueSource(strings = {
            "2020-06-1819:03:41.695Z",
            "2021-02-11T00:48:55+0000",
            "2021-02-11T00:48:55",
            "20210211T004855Z"})
    public void parseShouldThrowDateTimeParseException(final String d) {
        assertThrows(DateTimeParseException.class, () -> DateHelpers.parse(d));
    }

    /***
     * Should return an instance of {@link DateHelpers} class.
     * @param d1 ISO 8601 formatted date time string
     * @param d2 ISO 8601 formatted date time string
     */
    @ParameterizedTest(name = "{index} {0}, {1} validate.")
    @MethodSource("providePassingParameters")
    public void ctrShouldNotThrowException(final String d1, final String d2) {

        assertDoesNotThrow(() -> new DateHelpers(d1, d2));
    }

    /***
     * Should throw {@link IllegalArgumentException}.
     *
     * @see DateHelpers
     * @param d1 ISO 8601 formatted date time string
     * @param d2 ISO 8601 formatted date time string
     */
    @ParameterizedTest(name = "Constructor throws IllegalArgumentException")
    @MethodSource("provideIllegalParameters")
    public void ctrShouldThrowIllegalArgumentException(final String d1,
                                                       final String d2) {

        System.out.println(d1);
        System.out.println(d2);
        assertThrows(IllegalArgumentException.class,
                () -> new DateHelpers(d1, d2));
    }

    /***
     * Should throw {@link DateTimeParseException}.
     * If parameters are not valid ISO 8601 format,
     * than DateHelpers constructor should throw a
     * DateTimeParseException.
     *
     * @see DateHelpers
     * @param d1 ISO 8601 formatted date time string
     * @param d2 ISO 8601 formatted date time string
     */
    @ParameterizedTest(name = "{index} {0}, {1} validate.")
    @MethodSource("provideFailingParameters")
    public void ctrShouldThrowDateTimeParseException(final String d1,
                                                     final String d2) {

        assertThrows(DateTimeParseException.class,
                () -> new DateHelpers(d1, d2));
    }
}

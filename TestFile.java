import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//Tests done by Hasan Hasan - 23336901

class DayTest {

    @Test
    //Creates a day which is the 0th day of the month. This is not possible, an exception is expected.
    void testConstructor_dayNumber_zeroInput() {
        try {
            Day day = new Day(0, 2);
            fail("(F) Zero allowed as input for day of the month number");
        } catch (IllegalArgumentException ignored) {
        } catch (Exception e) {
            fail("(F) Expected Illegal Argument Exception to be Thrown, different exception throw");
        }
    }

    @Test
    //Creates a day which has a negative input for which day of the month it is (-3). This is not possible, an exception is expected.
    void testConstructor_dayNumber_negativeInput() {
        try {
            Day day = new Day(-3, 2);
            fail("(F) Negative numbers allowed as input for day of the month number");
        } catch (IllegalArgumentException ignored) {
        } catch (Exception e) {
            fail("(F) Expected Illegal Argument Exception to be Thrown, different exception throw");
        }
    }

    @Test
    /*Creates a day which has a negative index (-1) for day of the week.
    All days of the week have index (0-6), hence this is impossible, exception expected.
     */
    void testConstructor_dayOfWeek_negativeInput() {
        try {
            Day day = new Day(2, -1);
            fail("(F) Negative numbers allowed as input for day of the week");
        } catch (IllegalArgumentException ignored) {
        } catch (Exception e) {
            fail("(F) Expected Illegal Argument Exception to be Thrown, different exception throw");
        }
    }

    @Test
    /*Creates a day which has a 7th index for day of the week, being the day after Saturday but not Sunday
    All days of the week have index (0-6), hence this is impossible, exception expected.
     */
    void testConstructor_dayOfWeek_indexSevenInput() {
        try {
            Day day = new Day(3, 7);
            fail("(F) Day of the week allowed to be the '8th' day of the week, which doesn't exist");
        } catch (IllegalArgumentException ignored) {
        } catch (Exception e) {
            fail("(F) Expected Illegal Argument Exception to be Thrown, different exception throw");
        }
    }

    @Test
    /*Creates a day which has a very large index for day of the week (25911)
    All days of the week have index (0-6), hence this is impossible, exception expected.
     */
    void testConstructor_dayOfWeek_25911indexInput() {
        try {
            Day day = new Day(3, 25911);
            fail("(F) Day of the week index allowed to be a very large value (25911), which doesn't exist");
        } catch (IllegalArgumentException ignored) {
        } catch (Exception e) {
            fail("(F) Expected Illegal Argument Exception to be Thrown, different exception throw");
        }
    }

    @Test
    //Testing getter method for day of the week the day falls on. Should return our input correctly.
    void testGetter_dayOfWeek_input3() {
        Day day = new Day(2, 3);
        assertEquals(3, day.getDayOfWeek(), "(F) Getter for Day of the week returned different value than input");
    }

    @Test
    //Testing getter method for day of the month the day falls on. Should return our input correctly.
    void testGetter_dayNumber_input2() {
        Day day = new Day(2, 3);
        assertEquals(2, day.getDayNumber(), "(F) Getter for Day of the month returned different value than input");
    }

    @Test
    //Using Equals method to compare a day to itself (same object and reference). Should output true, since a day is always equal to itself.
    void testEquals_reflexive() {
        Day day = new Day(12, 12);
        assertEquals(true, day.equals(day), "(F) A day doesn't equal itself through the equals method");
    }

    @Test
    /*Using Equals method to compare two days with the same address, hence same day instance.
    Should output true, since they are referring to the same object.
     */
    void testEquals_sameInstance() {
        Day day = new Day(12, 12);
        Day day2 = day;
        assertEquals(true, day.equals(day2), "(F) A day doesn't equal another day which has the same reference address through the equals method");
        assertEquals(true, day2.equals(day), "(F) A day doesn't equal another day which has the same reference address through the equals method");
    }

    @Test
    //Comparing a day to a null reference, which should always be not equal to.
    void testEquals_nullReference() {
        Day day = new Day(12, 12);
        Day day2 = null;
        assertEquals(false, day.equals(day2), "(F) A day equals a null object through the equals method");
    }

    @Test
    /* Comparing a day to an instance of a different class, where they have same input (int 12, int 10),
    to check if the method blindingly return true by just comparing values. Should return false, since they are
    different classes
     */
    void testEquals_differentClass() {
        Day day = new Day(12, 10);
        Month month = new Month(12, 10);

        assertEquals(false, day.equals(month), "(F) A day equals another object of different class through equals method");
    }

    @Test
    /*Comparing a day with different days when at least one instance variable is different.
    Should return false, since all variables need to be a perfect match for two days to be equal
     */
    void testEquals_differentValues() {
        Day day = new Day(12, 10);

        //Two different values
        Day day2 = new Day(6, 6);

        //One different value
        Day day3 = new Day(12, 5);
        Day day4 = new Day(8, 10);

        assertEquals(false, day.equals(day2), "(F) a day equals another day with different day of the week and day of the month through the equals method");
        assertEquals(false, day.equals(day3), "(F) a day equals another day with different day of the week through the equals method" );
        assertEquals(false, day.equals(day4), "(F) a day equals another day with different day of the month through the equals method");
    }

    @Test
    //Comparing two days when all the variables have the same value. Should be considered equal and return true
    void testEquals_sameValues() {
        Day day = new Day(2, 8);
        Day day2 = new Day(2, 8);
        assertEquals(true, day.equals(day2), "(F) a day doesn't equal another day with matching day of the week and day of the month through the equals method");
    }
}


class MonthTest {
    @Test
    //Giving a month a negative index of (-1), which is the month before the first month. We expect an exception since this is not possible.
    void testConstructor_monthIndex_negativeInput() {
        try {
            Month month = new Month(-1, 2);
            fail("(F) Negative numbers allowed as input for month index");
        } catch (IllegalArgumentException ignored) {
        } catch (Exception e) {
            fail("(F) Expected Illegal Argument Exception to be Thrown, different exception throw");
        }
    }

    @Test
    //We set the total number of days in the month to be zero. This should return an exception as the month would useless with no days.
    void testConstructor_daysInMonth_zeroInput() {
        try {
            Day day = new Day(2, 0);
            fail("(F) Zero allowed as input for number of days in the month");
        } catch (IllegalArgumentException ignored) {
        } catch (Exception e) {
            fail("(F) Expected Illegal Argument Exception to be Thrown, different exception throw");
        }
    }

    @Test
    //We set the total number of days in the month to be a negative number (-1). Clearly not possible, we expect an exception.
    void testConstructor_daysInMonth_negativeInput() {
        try {
            Day day = new Day(2, -1);
            fail("(F) Negative numbers allowed as input for number of days in the month");
        } catch (IllegalArgumentException ignored) {
        } catch (Exception e) {
            fail("(F) Expected Illegal Argument Exception to be Thrown, different exception throw");
        }
    }

    @Test
    /*Testing getter method for which month of the year the month is (subtracting -1, since it's the index, which starts at 0)
    Should return the same input we enter in (4).
     */
    void testGetter_monthIndex() {
        Month month = new Month(4, 6);
        assertEquals(4, month.getMonthIndex(), "(F) Getter for index of the month returned different value than input");
    }

    @Test
    //Testing getter method for how many days there are in the month. Should return the same input we enter in (6).
    void testGetter_daysInMonth() {
        Month month = new Month(4, 6);
        assertEquals(6, month.getDaysInMonth(), "(F) Getter for number of days in the month returned different value from input");
    }

    @Test
    //Using Equals method to compare a month to itself (same reference). Should output true, since a month is always equal to itself.
    void testEquals_reflexive() {
        Month month = new Month(11, 8);
        assertEquals(true, month.equals(month), "(F) A month doesn't equal itself through the equals method");
    }

    @Test
    /*Using Equals method to compare two months with the same address.
    Should output true, since they are referring to the same instance.
     */
    void testEquals_sameInstance() {
        Month month = new Month(11, 2);
        Month month2 = month;
        assertEquals(true, month.equals(month2), "(F) A month doesn't equal another month which has the same reference address through the equals method");
        assertEquals(true, month2.equals(month), "(F) A month doesn't equal another month which has the same reference address through the equals method");
    }

    @Test
    //Comparing a month to a null reference, which should always be not equal to.
    void testEquals_nullReference() {
        Month month = new Month(12, 12);
        Month month2 = null;
        assertEquals(false, month.equals(month2), "(F) A month equals a null object through the equals method");
    }

    @Test
    /* Comparing a month to an instance of a different class, where they have same input (int 8, int 7),
    to check if the method blindingly return true by just comparing values. Should return false, since they are
    different classes
     */
    void testEquals_differentClass() {
        Month month = new Month(8, 7);
        //Constructor for day is working as seen from the unit tests 'MonthTest'
        Day day = new Day(8, 7);
        assertEquals(false, month.equals(day), "(F) A month equals another object of different class through equals method");
    }

    @Test
    /*Comparing a month with different months when at least one instance variable is different.
    Should return false, since all variables need to be a perfect match for two months to be equal
     */
    void testEquals_differentValues() {
        Month month = new Month(13, 11);

        //Two different values
        Month month2 = new Month(7, 7);

        //One different value
        Month month3 = new Month(13, 6);
        Month month4 = new Month(9, 11);

        assertEquals(false, month.equals(month2), "(F) a month equals another month with different month index and days in the month through the equals method");
        assertEquals(false, month.equals(month3), "(F) a month equals another month with different days in the month through the equals method");
        assertEquals(false, month.equals(month4), "(F) a month equals another month with different month index through the equals method");
    }

    @Test
    //Comparing two months when all the variables have the same value. Should be considered equal and return true
    void testEquals_sameValues() {
        Month month = new Month(16, 3);
        Month month2 = new Month(16, 3);
        assertEquals(true, month.equals(month2), "(F) a month doesn't equal another month with matching month index and days in the month through the equals method");
    }
}


class CalendarTest {
    @Test
    //Letting the total number of days in a year be a negative value (-120). Not possible, an exception is expected
    void testConstructor_totalDays_negativeValueInput() {
        try {
            Calendar calendar = new Calendar(-120, 3, new int[]{5, 6, 7} );
            fail("(F) Negative numbers allowed as input for total days in a year");
        } catch (IllegalArgumentException ignored) {
        } catch (Exception e) {
            fail("(F) Expected Illegal Argument Exception to be Thrown, different exception throw");
        }
    }

    @Test
    //Letting the total number of days in a year be 0. Trivial calendar, an exception is expected.
    void testConstructor_totalDays_zeroInput() {
        try {
            Calendar calendar = new Calendar(0, 3, new int[]{5, 6, 7} );
            fail("(F) Zero allowed as input for total days in a year");
        } catch (IllegalArgumentException ignored) {
        } catch (Exception e) {
            fail("(F) Expected Illegal Argument Exception to be Thrown, different exception throw");
        }
    }

    @Test
    //Letting the total number of months in the year be a negative number (-8). Not possible, an exception is expected
    void testConstructor_numberOfMonths_negativeValueInput() {
        try {
            Calendar calendar = new Calendar(160, -120, new int[]{} );
            fail("(F) Negative numbers allowed as input for number of months in a year");
        } catch (IllegalArgumentException ignored) {
        } catch (NegativeArraySizeException e) {
            fail("(F) Negative numbers allowed as input for number of months in a year");
        } catch (Exception e) {
            fail("(F) Expected Illegal Argument Exception to be Thrown, different exception throw");
        }

    }

    @Test
    //Letting the total number of months in the year be zero. Trivial calendar, an exception is expected.
    void testConstructor_numberOfMonths_zeroInput() {
        try {
            Calendar calendar = new Calendar(5, 0, new int[]{} );
            fail("(F) Zero allowed as input for number of months in a year");
        } catch (IllegalArgumentException ignored) {
        } catch (Exception e) {
            fail("(F) Expected Illegal Argument Exception to be Thrown, different exception throw");
        }
    }

    @Test
    /*Letting the inputted number of months in a year value (3) be different from the array length of the
    array which contains values on how many days each month has (4). Since they do not match in our input,
    an exception is expected
     */
    void TestConstructor_daysInMonths_arraySizeMismatchWithNumberOfMonths() {
        try {
            //numberOfMonths = 3, but we have an array of 4 months
            Calendar calendar = new Calendar(100, 3, new int[] {25,25,25,25});
            fail("(F) The number of months inputed not matching the length of the array for the number of days per each month should" +
                    "return an exception, no exception was thrown");
        } catch (IllegalArgumentException ignored) {
        } catch (Exception e) {
            fail("(F) Expected Illegal Argument Exception to be Thrown, different exception throw");
        }
    }

    @Test
    //Letting one of the months have zero days. A month can't have zero days (trivial), hence an exception is expected.
    void testConstructor_daysInMonths_zeroInputForMonth() {
        try {
            Calendar calendar = new Calendar(100, 4, new int[] {50, 30, 20, 0});
            fail("(F) Zero allowed as input for number of days in a month");
        } catch (IllegalArgumentException ignored) {
        } catch (Exception e) {
            fail("(F) Expected Illegal Argument Exception to be Thrown, different exception throw");
        }
    }

    @Test
    //Having more months in a year than days in a year. Not possible, an exception is expected.
    void testConstructor_moreMonthsThanDaysInYear() {
        try {
            Calendar calendar = new Calendar(3, 5, new int[] {0, 0, 1, 1, 1});
            fail("(F) Allowed to have an input where there is more months in a year than days in a year");
        } catch (IllegalArgumentException ignored) {
        } catch (Exception e) {
            fail("(F) Expected Illegal Argument Exception to be Thrown, different exception throw");
        }
    }

    @Test
    //Letting a month have a negative number of days (-10). This is impossible, we expect and exception.
    void testConstructor_daysInMonths_negativeValueInputForMonth() {
        try {
            Calendar calendar = new Calendar(90, 4, new int[] {50, 30, 20, -10});
            fail("(F) Negative value allowed as input for number of days in a month");
        } catch (IllegalArgumentException ignored) {
        } catch (Exception e) {
            fail("(F) Expected Illegal Argument Exception to be Thrown, different exception throw");
        }
    }

    @Test
    /*Letting the total number of days in a year not match up with the sum of days from all the months.
    We expect and exception.
     */
    void testConstructor_daysInMonths_mismatchWithDaysInYear() {
        try {
            Calendar calendar = new Calendar(100, 5, new int[] {15,15,15,15,15});
            fail("(F) Number of days in a year not being the same as the sum of all days from all months should give an exception");
        } catch (IllegalArgumentException ignored) {
        } catch (Exception e) {
            fail("(F) Expected Illegal Argument Exception to be Thrown, different exception throw");
        }
    }

    /* Testing the method to calculate how many Friday 13th's there are in a certain calendar. I implemented
    6 different random cases, with a corresponding correct answer for each.
     */
    @Test
    void testFriday13thCalculator_input_1dayPerMonth() {
        Calendar calendar = new Calendar( 7, 7, new int[]{1,1,1,1,1,1,1});
        assertEquals(0, calendar.countFridaysOn13th(),
                "(F) Incorrect number of Friday13th's count where there are 7 months, each having 1 day");
    }
    @Test
    void testFriday13thCalculator_input_12daysPerMonth() {
        Calendar calendar = new Calendar(60, 5, new int[]{12,12,12,12,12});
        assertEquals(0, calendar.countFridaysOn13th(),
                "(F) Incorrect number of Friday13th's count where there are 6 months, each having 12 days");
    }
    @Test
    void testFriday13thCalculator_input_14dayPerMonth() {
        Calendar calendar = new Calendar(84, 6, new int[]{14,14,14,14,14,14});
        assertEquals(6, calendar.countFridaysOn13th(),
                "(F) Incorrect number of Friday13th's count where there are 6 months, each having 14 days");
    }
    @Test
    void testFriday13thCalculator_input_randomConfig() {
        Calendar calendar = new Calendar(54, 4, new int[]{12,10,18,14});
        assertEquals(0, calendar.countFridaysOn13th(),
                "(F) Incorrect number of Friday13th's count for a random configuration (1)");
    }
    @Test
    void testFriday13thCalculator_input_randomConfig2() {
        Calendar calendar = new Calendar(93, 6, new int[]{13,14,15,16,17,18});
        assertEquals(2, calendar.countFridaysOn13th(),
                "(F) Incorrect number of Friday13th's count for a random configuration (2)");
    }
    @Test
    void testFriday13thCalculator_input_randomConfig3() {
        Calendar calendar = new Calendar(60, 3, new int[]{20,20,20});
        assertEquals(1, calendar.countFridaysOn13th(),
                "(F) Incorrect number of Friday13th's count for a random configuration (3)");
    }
}
/**
Given a date, return the corresponding day of the week for that date.

The input is given as three integers representing the day, month and year respectively.

Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.

Example 1:
Input: day = 31, month = 8, year = 2019
Output: "Saturday"
*/import java.util.Calendar;
import java.util.Calendar.Builder;
import java.util.Date;

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        Calendar.Builder cb = new Builder();
        cb.setDate(year, month - 1, day);
        Calendar date = cb.build();
        
        HashMap<Integer, String> weekDays = new HashMap<>();
        weekDays.put(1, "Sunday");
        weekDays.put(2, "Monday");
        weekDays.put(3, "Tuesday");
        weekDays.put(4, "Wednesday");
        weekDays.put(5, "Thursday");
        weekDays.put(6, "Friday");
        weekDays.put(7, "Saturday");
        
        return weekDays.get(date.get(Calendar.DAY_OF_WEEK));
    }
}
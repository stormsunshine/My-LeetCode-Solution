class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int dayIndex = getDayIndex(day, month, year);
        return DAYS[dayIndex];
    }

    public int getDayIndex(int day, int month, int year) {
        if (month < 3) {
            month += 12;
            year--;
        }
        int century = year / 100, year2 = year % 100;
		int index = year2 + year2 / 4 + century / 4 - 2 * century + 26 * (month + 1) / 10 + day - 1;
        index %= 7;
        if (index < 0)
            index += 7;
        return index;
    }
}
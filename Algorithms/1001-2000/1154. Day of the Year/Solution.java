class Solution {
    public int dayOfYear(String date) {
        String[] array = date.split("-");
        int year = Integer.parseInt(array[0]), month = Integer.parseInt(array[1]), day = Integer.parseInt(array[2]);
        if (month == 1)
            return day;
        if (month == 2)
            return 31 + day;
        int leap = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
        int dayOfYear = 31 + 28 + leap;
        if (month > 3)
            dayOfYear += 31;
        if (month > 4)
            dayOfYear += 30;
        if (month > 5)
            dayOfYear += 31;
        if (month > 6)
            dayOfYear += 30;
        if (month > 7)
            dayOfYear += 31;
        if (month > 8)
            dayOfYear += 31;
        if (month > 9)
            dayOfYear += 30;
        if (month > 10)
            dayOfYear += 31;
        if (month > 11)
            dayOfYear += 30;
        dayOfYear += day;
        return dayOfYear;
    }
}
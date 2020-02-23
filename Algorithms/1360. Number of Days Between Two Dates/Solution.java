class Solution {
    public int daysBetweenDates(String date1, String date2) {
        String[] array1 = date1.split("-");
        String[] array2 = date2.split("-");
        int year1 = Integer.parseInt(array1[0]), month1 = Integer.parseInt(array1[1]), day1 = Integer.parseInt(array1[2]);
        int year2 = Integer.parseInt(array2[0]), month2 = Integer.parseInt(array2[1]), day2 = Integer.parseInt(array2[2]);
        if (year1 > year2 || year1 == year2 && month1 > month2 || year1 == year2 && month1 == month2 && day1 > day2) {
            int temp = year1;
            year1 = year2;
            year2 = temp;
            temp = month1;
            month1 = month2;
            month2 = temp;
            temp = day1;
            day1 = day2;
            day2 = temp;
        }
        int numberOfDays1 = numberOfDays(year1, month1, day1);
        int numberOfDays2 = numberOfDays(year2, month2, day2);
        if (year1 == year2)
            return numberOfDays2 - numberOfDays1;
        else {
            int totalDays = (year2 - year1) * 365 - numberOfDays1 + numberOfDays2;
            int checkLeapYear = (int) Math.ceil(year1 / 4.0) * 4;
            while (checkLeapYear < year2) {
                if (isLeap(checkLeapYear))
                    totalDays++;
                checkLeapYear += 4;
            }
            return totalDays;
        }
    }

    public int numberOfDays(int year, int month, int day) {
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeap(year))
            monthDays[1]++;
        int numberOfDays = 0;
        for (int i = month - 2; i >= 0; i--)
            numberOfDays += monthDays[i];
        numberOfDays += day;
        return numberOfDays;
    }

    public boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
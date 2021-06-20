class Solution {
    public int numberOfRounds(String startTime, String finishTime) {
        int startHour = Integer.parseInt(startTime.substring(0, 2)), startMinute = Integer.parseInt(startTime.substring(3));
        int finishHour = Integer.parseInt(finishTime.substring(0, 2)), finishMinute = Integer.parseInt(finishTime.substring(3));
        if (finishHour < startHour || finishHour == startHour && finishMinute < startMinute)
            finishHour += 24;
        if (startMinute % 15 != 0) {
            startMinute = startMinute - startMinute % 15 + 15;
            if (startMinute == 60) {
                startHour++;
                startMinute = 0;
            }
        }
        if (finishMinute % 15 != 0)
            finishMinute -= finishMinute % 15;
        int minutesBetween = (finishHour - startHour) * 60 + (finishMinute - startMinute);
        minutesBetween = Math.max(minutesBetween, 0);
        int rounds = minutesBetween / 15;
        return rounds;
    }
}
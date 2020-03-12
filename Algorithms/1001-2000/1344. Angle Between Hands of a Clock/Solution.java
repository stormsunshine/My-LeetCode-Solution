class Solution {
    public double angleClock(int hour, int minutes) {
        double hoursDegree = hour * 30 + minutes * 30.0 / 60;
        int minutesDegree = minutes * 6;
        double angle = Math.abs(minutesDegree - hoursDegree);
        if (angle > 180)
            angle = 360 - angle;
        return angle;
    }
}
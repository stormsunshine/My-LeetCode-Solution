class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> timeList = new ArrayList<String>();
        for (int i = 0; i < 12; i++) {
            int minuteOnes = onesCount(i);
            if (minuteOnes > num)
                continue;
            for (int j = 0; j < 60; j++) {
                int secondOnes = onesCount(j);
                if (minuteOnes + secondOnes == num) {
                    String time = toTime(i, j);
                    timeList.add(time);
                }
            }
        }
        return timeList;
    }

    public int onesCount(int num) {
        int ones = 0;
        int remain = num;
        while (remain > 0) {
            ones += remain % 2;
            remain /= 2;
        }
        return ones;
    }

    public String toTime(int hour, int minute) {
        return hour + ":" + getTwo(minute);
    }

    public String getTwo(int num) {
        String str = String.valueOf(num);
        if (num < 10)
            str = "0" + str;
        return str;
    }
}
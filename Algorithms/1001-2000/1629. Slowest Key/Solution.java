class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char slowestKey = 'a';
        int slowestTime = 0;
        int length = releaseTimes.length;
        int prev = 0;
        for (int i = 0; i < length; i++) {
            int curr = releaseTimes[i];
            char key = keysPressed.charAt(i);
            int time = curr - prev;
            if (time > slowestTime) {
                slowestKey = key;
                slowestTime = time;
            } else if (time == slowestTime && key > slowestKey)
                slowestKey = key;
            prev = curr;
        }
        return slowestKey;
    }
}
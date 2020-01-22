class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        long sum = 0;
        for (int pile : piles)
            sum += pile;
        long low = 1, high = sum;
        while (low < high) {
            long speed = (high - low) / 2 + low;
            long time = timeToEat(piles, speed);
            if (time > H)
                low = speed + 1;
            else
                high = speed;
        }
        return (int) low;
    }

    public long timeToEat(int[] piles, long speed) {
        long time = 0;
        for (int pile : piles) {
            int curTime = (int) Math.ceil(1.0 * pile / speed);
            time += curTime;
        }
        return time;
    }
}
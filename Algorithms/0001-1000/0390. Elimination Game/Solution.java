class Solution {
    public int lastRemaining(int n) {
        int low = 1, high = n;
        int difference = 1;
        int direction = 1;
        while (low < high) {
            if (direction > 0) {
                if ((high - low) % (difference * 2) == 0)
                    high -= difference;
                low += difference;
            } else {
                if ((high - low) % (difference * 2) == 0)
                    low += difference;
                high -= difference;
            }
            difference *= 2;
            direction = -direction;
        }
        return low;
    }
}
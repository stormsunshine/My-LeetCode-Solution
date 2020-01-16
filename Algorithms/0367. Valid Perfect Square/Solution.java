class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1 || num == 4 || num == 9)
            return true;
        long numLong = (long) num;
        int low = 1, high = num / 2;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            long square = (long) mid * (long) mid;
            if (square == numLong)
                return true;
            else if (square > numLong)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }
}
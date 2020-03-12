class Solution {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        else if (x < 4)
            return 1;
        else if (x < 9)
            return 2;
        else if (x < 16)
            return 3;
        int low = 0, high = x / 2;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            long square = (long) mid * (long) mid;
            long nextSquare = ((long) mid + 1) * ((long) mid + 1);
            if (square == x || square < x && nextSquare > x)
                return mid;
            else if (square > x)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -low - 1;
    }
}
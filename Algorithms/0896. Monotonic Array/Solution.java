class Solution {
    public boolean isMonotonic(int[] A) {
        int length = A.length;
        if (length <= 2)
            return true;
        int prevDifference = 0;
        for (int i = 1; i < length; i++) {
            int difference = A[i] - A[i - 1];
            if (prevDifference > 0 && difference < 0 || prevDifference < 0 && difference > 0)
                return false;
            if (difference != 0)
                prevDifference = difference;
        }
        return true;
    }
}
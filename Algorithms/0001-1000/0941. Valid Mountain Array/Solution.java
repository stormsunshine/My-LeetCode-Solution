class Solution {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3)
            return false;
        int length = A.length;
        if (A[0] >= A[1] || A[length - 2] <= A[length - 1])
            return false;
        int topIndex = -1;
        for (int i = 1; i < length; i++) {
            int difference = A[i] - A[i - 1];
            if (difference == 0)
                return false;
            else if (difference < 0) {
                topIndex = i - 1;
                break;
            }
        }
        for (int i = topIndex + 1; i < length; i++) {
            int difference = A[i] - A[i - 1];
            if (difference >= 0)
                return false;
        }
        return true;
    }
}
class Solution {
    public int fixedPoint(int[] A) {
        int low = 0, high = A.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            int num = A[mid];
            if (num == mid)
                high = mid;
            else if (num > mid)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return A[low] == low ? low : -1;
    }
}
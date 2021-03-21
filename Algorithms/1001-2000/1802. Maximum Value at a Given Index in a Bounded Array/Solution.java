class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int low = 1, high = maxSum;
        while (low < high) {
            long mid = (high - low + 1) / 2 + low;
            long sumLeft = ((mid - index) + (mid - 1)) * index / 2;
            if (mid <= index)
                sumLeft = (mid - 1) * mid / 2 + index - mid + 1;
            sumLeft = Math.max(sumLeft, index);
            long sumRight = ((mid - 1) + (mid - (n - 1 - index))) * (n - index - 1) / 2;
            if (mid <= n - 1 - index)
                sumRight = (mid - 1) * mid / 2 + (n - 1 - index - mid) + 1;
            sumRight = Math.max(sumRight, n - index - 1);
            long sum = sumLeft + sumRight + mid;
            if (sum > maxSum)
                high = (int) mid - 1;
            else
                low = (int) mid;
        }
        return low;
    }
}
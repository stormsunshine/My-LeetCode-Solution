class Solution {
    public int maximumSum(int[] arr) {
        int length = arr.length;
        int max1 = arr[0];
        int max2 = arr[0];
        int max3 = arr[0];
        int max = arr[0];
        for (int i = 1; i < length; i++) {
            int newMax1 = Math.max(max1 + arr[i], arr[i]);
            int newMax2 = Math.max(Math.max(max2, max3) + arr[i], arr[i]);
            int newMax3 = max1;
            max1 = newMax1;
            max2 = newMax2;
            max3 = newMax3;
            max = Math.max(max, Math.max(Math.max(max1, max2), max3));
        }
        return max;
    }
}
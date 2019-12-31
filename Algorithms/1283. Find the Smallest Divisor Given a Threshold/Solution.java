class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        long arraySum = 0;
        for (int num : nums)
            arraySum += num;
        long low = 1, high = arraySum;
        while (low < high) {
            long mid = (high - low) / 2 + low;
            int sum = 0;
            for (int num : nums) {
                int quotient = (int) Math.ceil(num * 1.0 / mid);
                sum += quotient;
            }
            if (sum > threshold)
                low = mid + 1;
            else
                high = mid;
        }
        return (int) low;
    }
}
class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        final int MODULO = 1000000007;
        int length = nums.length;
        int[] counts = new int[length];
        for (int[] request : requests) {
            int start = request[0], end = request[1];
            counts[start]++;
            if (end + 1 < length)
                counts[end + 1]--;
        }
        for (int i = 1; i < length; i++)
            counts[i] += counts[i - 1];
        Arrays.sort(counts);
        Arrays.sort(nums);
        long sum = 0;
        for (int i = 0; i < length; i++)
            sum += (long) nums[i] * counts[i];
        return (int) (sum % MODULO);
    }
}
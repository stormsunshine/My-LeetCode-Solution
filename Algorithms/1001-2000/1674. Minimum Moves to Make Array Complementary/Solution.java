class Solution {
    public int minMoves(int[] nums, int limit) {
        int sumLimit = limit * 2;
        int[] differences = new int[sumLimit + 1];
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int sum = nums[i] + nums[j];
            int curMinSum = Math.min(nums[i], nums[j]) + 1;
            int curMaxSum = Math.max(nums[i], nums[j]) + limit;
            differences[curMinSum]--;
            differences[sum]--;
            if (sum < sumLimit)
                differences[sum + 1]++;
            if (curMaxSum < sumLimit)
                differences[curMaxSum + 1]++;
        }
        int maxReduce = 0;
        for (int i = 1; i <= sumLimit; i++) {
            differences[i] += differences[i - 1];
            maxReduce = Math.min(maxReduce, differences[i]);
        }
        return nums.length + maxReduce;
    }
}
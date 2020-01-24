class Solution {
    public int movesToMakeZigzag(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        if (length == 1)
            return 0;
        if (length == 2)
            return nums[0] == nums[1] ? 1 : 0;
        int evenCounts = 0, oddCounts = 0;
        for (int i = 0; i < length; i += 2) {
            int num = nums[i];
            int minAdjacent = 0;
            if (i == 0)
                minAdjacent = nums[1];
            else if (i == length - 1)
                minAdjacent = nums[length - 2];
            else
                minAdjacent = Math.min(nums[i - 1], nums[i + 1]);
            evenCounts += Math.max(0, num - minAdjacent + 1);
        }
        for (int i = 1; i < length; i += 2) {
            int num = nums[i];
            int minAdjacent = 0;
            if (i == length - 1)
                minAdjacent = nums[length - 2];
            else
                minAdjacent = Math.min(nums[i - 1], nums[i + 1]);
            oddCounts += Math.max(0, num - minAdjacent + 1);
        }
        return Math.min(evenCounts, oddCounts);
    }
}
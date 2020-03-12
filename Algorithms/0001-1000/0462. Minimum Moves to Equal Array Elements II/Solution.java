class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int median = length % 2 == 0 ? (nums[length / 2 - 1] + nums[length / 2]) / 2 : nums[length / 2];
        int moves = 0;
        for (int num : nums)
            moves += Math.abs(num - median);
        return moves;
    }
}
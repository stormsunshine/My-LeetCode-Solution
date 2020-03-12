class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        int moves = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++)
            moves += nums[i] - min;
        return moves;
    }
}
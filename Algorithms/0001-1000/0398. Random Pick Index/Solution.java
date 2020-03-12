public class Solution {
    private int[] nums;
    private int length;

    public Solution(int[] nums) {
        this.nums = nums;
        length = nums.length;
    }
    
    public int pick(int target) {
        int index = 0;
        do {
            index = (int) (Math.random() * length);
        } while (nums[index] != target);
        return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
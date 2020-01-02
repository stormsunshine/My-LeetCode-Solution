class Solution {
    int length;
    int[] nums;

    public Solution(int[] nums) {
        length = nums.length;
        this.nums = new int[length];
        for (int i = 0; i < length; i++)
            this.nums[i] = nums[i];
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffled = new int[length];
        for (int i = 0; i < length; i++)
            shuffled[i] = nums[i];
        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * length);
            int temp = shuffled[i];
            shuffled[i] = shuffled[randomIndex];
            shuffled[randomIndex] = temp;
        }
        return shuffled;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
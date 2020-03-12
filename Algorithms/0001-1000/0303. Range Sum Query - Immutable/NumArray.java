class NumArray {
    int[] sums;

    public NumArray(int[] nums) {
        int length = nums.length;
        sums = new int[length];
        if (length > 0) {
            sums[0] = nums[0];
            for (int i = 1; i < length; i++)
                sums[i] = sums[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        if (i == 0)
            return sums[j];
        else
            return sums[j] - sums[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
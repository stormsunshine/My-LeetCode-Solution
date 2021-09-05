class Solution {
    public int countQuadruplets(int[] nums) {
        int count = 0;
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            for (int j = i + 1; j < length - 2; j++) {
                for (int k = j + 1; k < length - 1; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    for (int m = k + 1; m < length; m++) {
                        if (sum == nums[m])
                            count++;
                    }
                }
            }
        }
        return count;
    }
}
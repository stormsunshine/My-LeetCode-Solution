class Solution {
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long curNum = 0;
        long sum = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (num - sum > 1) {
                curNum = sum + 1;
                sum += curNum;
                patches++;
                if (sum >= n)
                    break;
            }
            sum += num;
            if (sum >= n)
                break;
        }
        curNum = sum + 1;
        while (sum < n) {
            sum += curNum;
            patches++;
            curNum = sum + 1;
        }
        return patches;
    }
}
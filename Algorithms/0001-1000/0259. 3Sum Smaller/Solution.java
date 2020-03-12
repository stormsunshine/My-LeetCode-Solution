class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        int length = nums.length;
        for (int midIndex = 1; midIndex < length - 1; midIndex++) {
            int leftIndex = midIndex - 1, rightIndex = midIndex + 1;
            while (rightIndex < length) {
                while (leftIndex >= 0 && nums[leftIndex] + nums[midIndex] + nums[rightIndex] >= target)
                    leftIndex--;
                if (leftIndex < 0)
                    break;
                count += leftIndex + 1;
                rightIndex++;
            }
        }
        return count;
    }
}
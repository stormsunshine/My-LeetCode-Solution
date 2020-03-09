class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        int low = 0, high = nums[length - 1] - nums[0];
        while (low < high) {
            int mid = (high - low) / 2 + low;
            int count = 0, left = 0;
            for (int right = 0; right < length; right++) {
                while (nums[right] - nums[left] > mid)
                    left++;
                count += right - left;
            }
            if (count >= k)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        if (length < 1)
            return 0;
        int result = length + 1;
        int sum = 0;
        int left = 0, right = 0;
        while (right < length) {
            sum += nums[right];
            while (sum >= s) {
                int temp = right - left + 1;
                if (temp < result)
                    result = temp;
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return result > length ? 0 : result;
    }
}
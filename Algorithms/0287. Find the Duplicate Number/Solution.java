class Solution {
    public int findDuplicate(int[] nums) {
        int length = nums.length;
        int low = 1, high = length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            int count = 0;
            for (int num : nums) {
                if (num <= mid)
                    count++;
            }
            if (count <= mid)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
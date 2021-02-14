class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        Arrays.sort(nums);
        int length = nums.length;
        int low = 1, high = nums[length - 1];
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (isPossible(nums, maxOperations, mid))
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    public boolean isPossible(int[] nums, int maxOperations, int penalty) {
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if (num <= penalty)
                break;
            int operations = nums[i] / penalty - 1;
            if (nums[i] % penalty != 0)
                operations++;
            count += operations;
        }
        return count <= maxOperations;
    }
}
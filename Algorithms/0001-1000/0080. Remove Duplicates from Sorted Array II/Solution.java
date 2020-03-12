class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        if (length <= 2)
            return length;
        int fast = 1, slow = 1;
        boolean duplicate = false;
        while (fast < length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                fast++;
                slow++;
                duplicate = false;
            } else {
                if (!duplicate) {
                    nums[slow] = nums[fast];
                    fast++;
                    slow++;
                    duplicate = true;
                } else {
                    while (fast < length && nums[fast] == nums[fast - 1])
                        fast++;
                    if (fast < length) {
                        nums[slow] = nums[fast];
                        fast++;
                        slow++;
                        duplicate = false;
                    }
                }
            }
        }
        return slow;
    }
}
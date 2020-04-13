class Solution {
    public int leastOpsExpressTarget(int x, int target) {
        int[] nums = new int[32];
        int index = 0;
        while (target > 0) {
            nums[index] = target % x;
            target /= x;
            index++;
        }
        int lastBackward = Integer.MAX_VALUE;
        int opsCount = -1;
        for (int i = index - 1; i >= 0; i--) {
            int count = i == 0 ? 2 : i;
            int forward = nums[i] * count;
            int backward = (x - nums[i]) * count + Math.min(lastBackward - i - 1, i + 1);
            opsCount += Math.min(forward, backward);
            lastBackward = Math.max(0, backward - forward);
        }
        return opsCount;
    }
}
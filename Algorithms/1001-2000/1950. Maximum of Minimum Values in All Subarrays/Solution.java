class Solution {
    public int[] findMaximums(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        Arrays.fill(right, length);
        int minimum = Integer.MAX_VALUE;
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            minimum = Math.min(minimum, nums[i]);
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i])
                right[stack.pop()] = i;
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int[] maximums = new int[length];
        Arrays.fill(maximums, minimum);
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            int range = right[i] - left[i] - 1;
            maximums[range - 1] = Math.max(maximums[range - 1], num);
        }
        for (int i = length - 2; i >= 0; i--)
            maximums[i] = Math.max(maximums[i], maximums[i + 1]);
        return maximums;
    }
}
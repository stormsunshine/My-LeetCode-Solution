class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int length = nums.length;
        int[] prevIndices = new int[length];
        int[] nextIndices = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (stack.size() > 1 && num <= nums[stack.peek()])
                stack.pop();
            prevIndices[i] = stack.peek();
            stack.push(i);
        }
        stack = new LinkedList<Integer>();
        stack.push(length);
        for (int i = length - 1; i >= 0; i--) {
            int num = nums[i];
            while (stack.size() > 1 && num <= nums[stack.peek()])
                stack.pop();
            nextIndices[i] = stack.peek();
            stack.push(i);
        }
        int[] maxIncrease = new int[length];
        Arrays.fill(maxIncrease, 1);
        int[] maxDecrease = new int[length];
        Arrays.fill(maxDecrease, 1);
        for (int i = 0; i < length; i++) {
            if (prevIndices[i] >= 0) {
                int num = nums[i];
                for (int j = prevIndices[i]; j >= 0; j--) {
                    if (nums[j] < num)
                        maxIncrease[i] = Math.max(maxIncrease[i], maxIncrease[j] + 1);
                }
            }
        }
        for (int i = length - 1; i >= 0; i--) {
            if (nextIndices[i] < length) {
                int num = nums[i];
                for (int j = nextIndices[i]; j < length; j++) {
                    if (nums[j] < num)
                        maxDecrease[i] = Math.max(maxDecrease[i], maxDecrease[j] + 1);
                }
            }
        }
        int maxLength = 0;
        for (int i = 0; i < length; i++) {
            if (maxIncrease[i] > 1 && maxDecrease[i] > 1) {
                int curLength = maxIncrease[i] + maxDecrease[i] - 1;
                maxLength = Math.max(maxLength, curLength);
            }
        }
        return length - maxLength;
    }
}
class Solution {
    public int maximumScore(int[] nums, int k) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        Arrays.fill(right, length);
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i])
                right[stack.pop()] = i;
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int score = 0;
        for (int i = 0; i < length; i++) {
            if (left[i] < k && right[i] > k)
                score = Math.max(score, nums[i] * (right[i] - left[i] - 1));
        }
        return score;
    }
}
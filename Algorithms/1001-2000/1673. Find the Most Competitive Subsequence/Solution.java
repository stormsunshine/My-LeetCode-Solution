class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int length = nums.length;
        int remove = length - k;
        if (remove == 0)
            return nums;
        Deque<Integer> stack = new LinkedList<Integer>();
        int index = 0;
        while (index < length && remove > 0) {
            int num = nums[index];
            while (!stack.isEmpty() && num < stack.peek() && remove > 0) {
                stack.pop();
                remove--;
            }
            stack.push(num);
            index++;
        }
        while (!stack.isEmpty() && remove > 0) {
            stack.pop();
            remove--;
        }
        int[] subsequence = new int[k];
        int size = stack.size();
        for (int i = size - 1; i >= 0; i--)
            subsequence[i] = stack.pop();
        for (int i = size; i < k; i++, index++)
            subsequence[i] = nums[index];
        return subsequence;
    }
}
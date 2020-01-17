class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;
        int length = nums.length;
        int[] minArray = new int[length];
        minArray[0] = nums[0];
        for (int i = 1; i < length; i++)
            minArray[i] = Math.min(minArray[i - 1], nums[i]);
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = length - 1; i >= 0; i--) {
            int num = nums[i];
            while (!stack.isEmpty() && stack.peek() <= minArray[i])
                stack.pop();
            if (!stack.isEmpty() && stack.peek() < num)
                return true;
            else
                stack.push(num);
        }
        return false;
    }
}
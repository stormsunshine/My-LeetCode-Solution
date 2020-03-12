class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < length; i++)
            list.add(nums[i]);
        int[] nextGreaterElements = new int[length];
        for (int i = 0; i < length; i++)
            nextGreaterElements[i] = -1;
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> indicesStack = new Stack<Integer>();
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (!stack.isEmpty() && stack.peek() < num) {
                int prevNum = stack.pop();
                int index = indicesStack.pop();
                nextGreaterElements[index] = num;
            }
            stack.push(num);
            indicesStack.push(i);
        }
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (!stack.isEmpty() && stack.peek() < num) {
                int prevNum = stack.pop();
                int index = indicesStack.pop();
                nextGreaterElements[index] = num;
            }
            stack.push(num);
            indicesStack.push(i);
        }
        return nextGreaterElements;
    }
}
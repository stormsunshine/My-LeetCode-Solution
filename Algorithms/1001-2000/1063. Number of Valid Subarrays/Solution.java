class Solution {
    public int validSubarrays(int[] nums) {
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<Integer> indexStack = new Stack<Integer>();
        int length = nums.length;
        int[] endIndices = new int[length];
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (!numStack.isEmpty() && numStack.peek() > num) {
                numStack.pop();
                int prevIndex = indexStack.pop();
                endIndices[prevIndex] = i - 1;
            }
            numStack.push(num);
            indexStack.push(i);
        }
        while (!numStack.isEmpty()) {
            numStack.pop();
            int prevIndex = indexStack.pop();
            endIndices[prevIndex] = length - 1;
        }
        int subarraysCount = 0;
        for (int i = 0; i < length; i++) {
            int curLength = endIndices[i] - i + 1;
            subarraysCount += curLength;
        }
        return subarraysCount;
    }
}
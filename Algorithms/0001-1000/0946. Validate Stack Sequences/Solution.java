class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<Integer>();
        int length = pushed.length;
        int pushIndex = 0, popIndex = 0;
        while (pushIndex < length && popIndex < length) {
            stack.push(pushed[pushIndex]);
            pushIndex++;
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
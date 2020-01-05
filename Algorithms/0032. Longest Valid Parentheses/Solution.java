class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int length = s.length();
        int maxLength = 0;
        stack.push(-1);
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(')
                stack.push(i);
            else {
                if (stack.size() > 1) {
                    stack.pop();
                    int prev = stack.peek();
                    maxLength = Math.max(maxLength, i - prev);
                } else {
                    stack.pop();
                    stack.push(i);
                }
            }
        }
        return maxLength;
    }
}
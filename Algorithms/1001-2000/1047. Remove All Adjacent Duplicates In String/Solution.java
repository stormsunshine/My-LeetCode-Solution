class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<Character>();
        int length = S.length();
        for (int i = length - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (stack.isEmpty() || stack.peek() != c)
                stack.push(c);
            else
                stack.pop();
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
    }
}
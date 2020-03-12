class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c != ')')
                stack.push(c);
            else {
                Queue<Character> queue = new LinkedList<Character>();
                while (!stack.isEmpty() && stack.peek() != '(')
                    queue.offer(stack.pop());
                stack.pop();
                while (!queue.isEmpty())
                    stack.push(queue.poll());
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();
        return sb.toString();
    }
}
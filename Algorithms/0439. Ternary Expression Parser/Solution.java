class Solution {
    public String parseTernary(String expression) {
        Stack<Character> stack1 = new Stack<Character>();
        Stack<Character> stack2 = new Stack<Character>();
        int length = expression.length();
        for (int i = 0; i < length; i++)
            stack1.push(expression.charAt(i));
        while (stack1.size() > 1) {
            char c1 = stack1.pop();
            char c2 = stack1.pop();
            if (c2 == ':')
                stack2.push(c1);
            else {
                char conditionChar = stack1.pop();
                boolean condition = conditionChar == 'T';
                char nextChar = condition ? c1 : stack2.peek();
                stack2.pop();
                stack1.push(nextChar);
            }
        }
        String value = String.valueOf(stack1.pop());
        return value;
    }
}
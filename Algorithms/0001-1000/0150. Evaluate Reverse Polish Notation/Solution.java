class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int length = tokens.length;
        for (int i = 0; i < length; i++) {
            String token = tokens[i];
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                char op = token.charAt(0);
                switch (op) {
                    case '+':
                        stack.push(num1 + num2);
                        break;
                    case '-':
                        stack.push(num1 - num2);
                        break;
                    case '*':
                        stack.push(num1 * num2);
                        break;
                    case '/':
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            } else
                stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }
}
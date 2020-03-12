class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        s = s.replaceAll(" ", "");
        List<String> postfix = infixToPostfix(s);
        int result = calculatePostfix(postfix);
        return result;
    }

    public List<String> infixToPostfix(String s) {
        int length = s.length();
        List<String> expression = new ArrayList<String>();
        int num = -1;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int digit = c - '0';
                if (num < 0)
                    num = 0;
                num = num * 10 + digit;
            } else {
                if (num >= 0) {
                    expression.add(String.valueOf(num));
                    num = -1;
                }
                expression.add(String.valueOf(c));
            }
        }
        if (num >= 0)
            expression.add(String.valueOf(num));
        List<String> postfix = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        int size = expression.size();
        for (int i = 0; i < size; i++) {
            String element = expression.get(i);
            if (Character.isDigit(element.charAt(0)))
                postfix.add(element);
            else {
                int precedence = getPrecedence(element);
                if (stack.isEmpty())
                    stack.push(element);
                else {
                    while (!stack.isEmpty() && getPrecedence(stack.peek()) >= precedence)
                        postfix.add(stack.pop());
                    stack.push(element);
                }
            }
        }
        while (!stack.isEmpty())
            postfix.add(stack.pop());
        return postfix;
    }

    public int calculatePostfix(List<String> postfix) {
        Stack<Integer> stack = new Stack<Integer>();
        int size = postfix.size();
        for (int i = 0; i < size; i++) {
            String element = postfix.get(i);
            if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                if (element.equals("+"))
                    stack.push(num1 + num2);
                else if (element.equals("-"))
                    stack.push(num1 - num2);
                else if (element.equals("*"))
                    stack.push(num1 * num2);
                else if (element.equals("/"))
                    stack.push(num1 / num2);
            } else
                stack.push(Integer.parseInt(element));
        }
        return stack.pop();
    }

    public int getPrecedence(String operator) {
        if (operator.equals("*") || operator.equals("/"))
            return 2;
        else if (operator.equals("+") || operator.equals("-"))
            return 1;
        else
            return 0;
    }
}
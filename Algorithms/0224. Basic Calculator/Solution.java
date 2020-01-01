class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        s = s.replaceAll(" ", "");
        StringBuffer sb = new StringBuffer(s);
        int length = sb.length();
        for (int i = length - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == '-' && (i == 0 || sb.charAt(i - 1) == '('))
                sb.insert(i, '0');
        }
        s = sb.toString();
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
                if (element.equals("("))
                    stack.push(element);
                else if (element.equals(")")) {
                    while (!stack.isEmpty() && !stack.peek().equals("("))
                        postfix.add(stack.pop());
                    if (!stack.isEmpty() && stack.peek().equals("("))
                        stack.pop();
                } else {
                    if (stack.isEmpty() || stack.peek().equals("("))
                        stack.push(element);
                    else {
                        while (!stack.isEmpty() && !stack.peek().equals("("))
                            postfix.add(stack.pop());
                        stack.push(element);
                    }
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
            if (element.equals("+") || element.equals("-")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int newNum = element.equals("+") ? num1 + num2 : num1 - num2;
                stack.push(newNum);
            } else
                stack.push(Integer.parseInt(element));
        }
        return stack.pop();
    }
}
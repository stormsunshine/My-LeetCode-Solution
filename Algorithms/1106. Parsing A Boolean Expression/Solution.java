class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<Character>();
        int length = expression.length();
        for (int i = 0; i < length; i++) {
            char c = expression.charAt(i);
            if (c == ',')
                continue;
            else if (c == ')') {
                int tCount = 0, fCount = 0;
                while (stack.peek() != '(') {
                    char prevC = stack.pop();
                    if (prevC == 't')
                        tCount++;
                    else if (prevC == 'f')
                        fCount++;
                }
                stack.pop();
                char operator = stack.pop();
                if (operator == '!') {
                    if (tCount == 1)
                        stack.push('f');
                    else
                        stack.push('t');
                } else if (operator == '&') {
                    if (fCount == 0)
                        stack.push('t');
                    else
                        stack.push('f');
                } else if (operator == '|') {
                    if (tCount == 0)
                        stack.push('f');
                    else
                        stack.push('t');
                }
            } else
                stack.push(c);
        }
        return stack.pop() == 't' ? true : false;
    }
}
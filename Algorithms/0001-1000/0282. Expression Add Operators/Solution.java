class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> expressions = new ArrayList<String>();
        int length = num.length();
        if (length == 0)
            return expressions;
        else if (length == 1) {
            if (target == Integer.parseInt(num))
                expressions.add(num);
        } else
            backtrack(num, target, 0, 1, new ArrayList<String>(), expressions);
        return expressions;
    }

    public void backtrack(String num, int target, int prevIndex, int index, List<String> curExpression, List<String> expressions) {
        if (index == num.length()) {
            curExpression.add(num.substring(prevIndex, index));
            long result = evaluate(curExpression);
            if (result == (long) target) {
                StringBuffer sb = new StringBuffer();
                int size = curExpression.size();
                for (int i = 0; i < size; i++)
                    sb.append(curExpression.get(i));
                expressions.add(sb.toString());
            }
        } else {
            List<String> curExpression1 = new ArrayList<String>(curExpression);
            curExpression1.add(num.substring(prevIndex, index));
            curExpression1.add("+");
            backtrack(num, target, index, index + 1, curExpression1, expressions);
            List<String> curExpression2 = new ArrayList<String>(curExpression);
            curExpression2.add(num.substring(prevIndex, index));
            curExpression2.add("-");
            backtrack(num, target, index, index + 1, curExpression2, expressions);
            List<String> curExpression3 = new ArrayList<String>(curExpression);
            curExpression3.add(num.substring(prevIndex, index));
            curExpression3.add("*");
            backtrack(num, target, index, index + 1, curExpression3, expressions);
            if (num.charAt(prevIndex) != '0')
                backtrack(num, target, prevIndex, index + 1, curExpression, expressions);
        }
    }

    public long evaluate(List<String> expression) {
        List<String> postfix = new ArrayList<String>();
        Stack<String> opStack = new Stack<String>();
        int size = expression.size();
        for (int i = 0; i < size; i++) {
            String element = expression.get(i);
            if (Character.isDigit(element.charAt(0)))
                postfix.add(element);
            else {
                if (element.equals("+") || element.equals("-")) {
                    while (!opStack.isEmpty())
                        postfix.add(opStack.pop());
                    opStack.push(element);
                } else {
                    while (!opStack.isEmpty() && opStack.peek().equals("*"))
                        postfix.add(opStack.pop());
                    opStack.push(element);
                }
            }
        }
        while (!opStack.isEmpty())
            postfix.add(opStack.pop());
        Stack<Long> numStack = new Stack<Long>();
        size = postfix.size();
        for (int i = 0; i < size; i++) {
            String str = postfix.get(i);
            if (Character.isDigit(str.charAt(0)))
                numStack.push(Long.parseLong(str));
            else {
                long num2 = numStack.pop();
                long num1 = numStack.pop();
                char op = str.charAt(0);
                switch (op) {
                    case '+':
                        numStack.push(num1 + num2);
                        break;
                    case '-':
                        numStack.push(num1 - num2);
                        break;
                    case '*':
                        numStack.push(num1 * num2);
                        break;
                    default:
                }
            }
        }
        return numStack.pop();
    }
}
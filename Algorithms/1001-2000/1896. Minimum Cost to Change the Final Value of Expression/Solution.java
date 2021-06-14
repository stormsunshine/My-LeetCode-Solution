class Solution {
    public int minOperationsToFlip(String expression) {
        Deque<Integer> numStack = new LinkedList<Integer>();
        Deque<Integer> opStack = new LinkedList<Integer>();
        Deque<Character> signStack = new LinkedList<Character>();
        int length = expression.length();
        for (int i = 0; i < length; i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                numStack.push((int) (c - '0'));
                opStack.push(1);
            } else if (c == ')')
                signStack.pop();
            else {
                signStack.push(c);
                continue;
            }
            if (numStack.size() > 1 && signStack.peek() != '(') {
                int num2 = numStack.pop();
                int num1 = numStack.pop();
                int op2 = opStack.pop();
                int op1 = opStack.pop();
                char sign = signStack.pop();
                int[] ops = minOp(num1, num2, op1, op2, sign);
                numStack.push(ops[0]);
                opStack.push(ops[1]);
            }
        }
        return opStack.pop();
    }

    public int[] minOp(int num1, int num2, int op1, int op2, char sign) {
        if (sign == '&') {
            if (num1 == 1 && num2 == 1)
                return new int[]{1, Math.min(op1, op2)};
            else if (num1 == 0 && num2 == 0)
                return new int[]{0, Math.min(op1, op2) + 1};
            else
                return new int[]{0, 1};
        } else {
            if (num1 == 0 && num2 == 0)
                return new int[]{0, Math.min(op1, op2)};
            else if (num1 == 1 && num2 == 1)
                return new int[]{1, Math.min(op1, op2) + 1};
            else
                return new int[]{1, 1};
        }
    }
}
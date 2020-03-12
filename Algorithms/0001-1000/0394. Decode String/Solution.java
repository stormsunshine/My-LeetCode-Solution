class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return s;
        Stack<String> stack = new Stack<String>();
        int count = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                count *= 10;
                count += c - '0';
            } else {
                if (count > 0) {
                    stack.push(String.valueOf(count));
                    count = 0;
                }
                if (c == '[') {
                    stack.push(String.valueOf(c));
                } else if (c == ']') {
                    String str = stack.pop();
                    stack.pop();
                    int curCount = Integer.parseInt(stack.pop());
                    StringBuffer curSB = new StringBuffer();
                    for (int j = 0; j < curCount; j++)
                        curSB.append(str);
                    while (!stack.isEmpty() && !stack.peek().equals("["))
                        curSB.insert(0, stack.pop());
                    stack.push(curSB.toString());
                } else {
                    if (!stack.isEmpty() && Character.isLetter(stack.peek().charAt(0))) {
                        StringBuffer curSB = new StringBuffer(stack.pop());
                        curSB.append(c);
                        stack.push(curSB.toString());
                    } else
                        stack.push(String.valueOf(c));
                }
            }
        }
        return stack.pop();
    }
}
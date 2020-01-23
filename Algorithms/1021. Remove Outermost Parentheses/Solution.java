class Solution {
    public String removeOuterParentheses(String S) {
        List<Integer> indices = new ArrayList<Integer>();
        Stack<Character> stack = new Stack<Character>();
        int length = S.length();
        int begin = 0;
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == '(')
                stack.push(c);
            else {
                stack.pop();
                if (stack.isEmpty()) {
                    indices.add(begin);
                    indices.add(i);
                    begin = i + 1;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if (!indices.contains(i))
                sb.append(S.charAt(i));
        }
        return sb.toString();
    }
}
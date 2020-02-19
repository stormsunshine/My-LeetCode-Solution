class Solution {
    public boolean isValid(String S) {
        Stack<Character> stack = new Stack<Character>();
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == 'a' || c == 'b')
                stack.push(c);
            else {
                if (stack.size() < 2)
                    return false;
                char c2 = stack.pop();
                char c1 = stack.pop();
                if (c2 != 'b' || c1 != 'a')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
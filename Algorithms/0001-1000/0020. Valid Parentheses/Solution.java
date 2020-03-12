class Solution {
    public boolean isValid(String s) {
        char[] array = s.toCharArray();
        int length = array.length;
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put(')', '(');
        map.put('[', ']');
        map.put(']', '[');
        map.put('{', '}');
        map.put('}', '{');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < length; i++) {
            char c = array[i];
            if (isLeft(c))
                stack.push(c);
            else {
                char complement = map.get(c);
                if (stack.isEmpty() || stack.peek() != complement)
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public boolean isLeft(char c) {
        return c == '(' || c == '[' || c == '{';
    }
}
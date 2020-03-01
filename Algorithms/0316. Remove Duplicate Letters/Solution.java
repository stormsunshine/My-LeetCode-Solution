class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }
        Set<Character> set = new HashSet<Character>();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (set.contains(c))
                continue;
            while (!stack.isEmpty() && stack.peek() > c) {
                int lastIndex = map.get(stack.peek());
                if (lastIndex > i) {
                    char prevC = stack.pop();
                    set.remove(prevC);
                } else
                    break;
            }
            set.add(c);
            stack.push(c);
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();
        return sb.toString();
    }
}
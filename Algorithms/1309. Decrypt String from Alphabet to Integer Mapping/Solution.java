class Solution {
    public String freqAlphabets(String s) {
        Stack<Character> stack = new Stack<Character>();
        int length = s.length();
        int index = length - 1;
        while (index >= 0) {
            char c = s.charAt(index);
            if (c == '#') {
                int num = Integer.parseInt(s.substring(index - 2, index));
                char letter = (char) (num - 1 + 'a');
                stack.push(letter);
                index -= 3;
            } else {
                char letter = (char) (c - '1' + 'a');
                stack.push(letter);
                index--;
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
    }
}
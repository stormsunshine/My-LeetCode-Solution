class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        StringBuffer sb = new StringBuffer();
        int length = s.length();
        int deleteCount = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c))
                sb.append(c);
            else if (c == '(') {
                sb.append(c);
                stack.push(i - deleteCount);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    sb.append(c);
                    stack.pop();
                } else
                    deleteCount++;
            }
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            sb.deleteCharAt(index);
        }
        return sb.toString();
    }
}
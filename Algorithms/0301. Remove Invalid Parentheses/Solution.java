class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int length = s.length();
        int deleteLeft = 0, deleteRight = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(')
                deleteLeft++;
            else if (c == ')') {
                if (deleteLeft > 0)
                    deleteLeft--;
                else
                    deleteRight++;
            }
        }
        Set<String> set = new HashSet<String>();
        backtrack(s, 0, 0, deleteLeft, deleteRight, new StringBuffer(), set);
        return new ArrayList<String>(set);
    }

    public void backtrack(String s, int index, int leftCount, int deleteLeft, int deleteRight, StringBuffer sb, Set<String> set) {
        if (index == s.length()) {
            if (deleteLeft == 0 && deleteRight == 0)
                set.add(sb.toString());
        } else {
            char c = s.charAt(index);
            if (c == '(') {
                if (deleteLeft > 0)
                    backtrack(s, index + 1, leftCount, deleteLeft - 1, deleteRight, sb, set);
                sb.append(c);
                backtrack(s, index + 1, leftCount + 1, deleteLeft, deleteRight, sb, set);
                sb.deleteCharAt(sb.length() - 1);
            } else if (c == ')') {
                if (deleteRight > 0)
                    backtrack(s, index + 1, leftCount, deleteLeft, deleteRight - 1, sb, set);
                if (leftCount > 0) {
                    sb.append(c);
                    backtrack(s, index + 1, leftCount - 1, deleteLeft, deleteRight, sb, set);
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
                backtrack(s, index + 1, leftCount, deleteLeft, deleteRight, sb, set);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int depth = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(')
                depth++;
            else if (s.charAt(i) == ')')
                depth--;
            maxDepth = Math.max(maxDepth, depth);
        }
        return maxDepth;
    }
}
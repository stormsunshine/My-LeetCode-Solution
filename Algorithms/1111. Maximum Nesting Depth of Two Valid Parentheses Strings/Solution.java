class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int length = seq.length();
        int[] depths = new int[length];
        int curDepth = -1;
        for (int i = 0; i < length; i++) {
            if (seq.charAt(i) == '(')
                depths[i] = ++curDepth;
            else
                depths[i] = curDepth--;
        }
        int[] split = new int[length];
        for (int i = 0; i < length; i++)
            split[i] = depths[i] % 2;
        return split;
    }
}
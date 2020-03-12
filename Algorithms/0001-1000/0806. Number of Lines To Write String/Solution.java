class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        final int MAX_WIDTH = 100;
        int linesCount = 1, curWidth = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            int width = widths[c - 'a'];
            if (curWidth + width <= MAX_WIDTH)
                curWidth += width;
            else {
                linesCount++;
                curWidth = width;
            }
        }
        return new int[]{linesCount, curWidth};
    }
}
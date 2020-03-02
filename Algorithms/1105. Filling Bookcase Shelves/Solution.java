class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int length = books.length;
        int[] dp = new int[length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= length; i++) {
            int curHeight = 0, curWidth = 0;
            for (int j = i - 1; j >= 0; j--) {
                int[] book = books[j];
                curHeight = Math.max(curHeight, book[1]);
                curWidth += book[0];
                if (curWidth > shelf_width)
                    break;
                dp[i] = Math.min(dp[i], dp[j] + curHeight);
            }
        }
        return dp[length];
    }
}
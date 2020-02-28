class Solution {
    public int mctFromLeafValues(int[] arr) {
        int length = arr.length;
        int[][] maxValues = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int maxValue = 0;
                for (int k = i; k <= j; k++) {
                    if (maxValue < arr[k])
                        maxValue = arr[k];
                }
                maxValues[i][j] = maxValue;
            }
        }
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++)
                dp[i][j] = Integer.MAX_VALUE;
        }
        for (int curLength = 1; curLength < length; curLength++) {
            int start = 0, end = length - curLength;
            for (int i = start; i < end; i++) {
                int midStart = i, midEnd = i + curLength;
                for (int j = midStart; j < midEnd; j++)
                    dp[i][i + curLength] = Math.min(dp[i][i + curLength], dp[i][j] + dp[j + 1][i + curLength] + maxValues[i][j] * maxValues[j + 1][i + curLength]);
            }
        }
        return dp[0][length - 1];
    }
}
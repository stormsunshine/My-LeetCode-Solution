class Solution {
    public int[] solve(int[] nums, int[][] queries) {
        final int MODULO = 1000000007;
        int length = nums.length;
        int sqrt = (int) Math.sqrt(length);
        int queriesCount = queries.length;
        int[] answer = new int[queriesCount];
        long[][] dp = new long[length][sqrt];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = 1; j < sqrt; j++) {
                if (i + j < length)
                    dp[i][j] = (nums[i] + dp[i + j][j]) % MODULO;
                else
                    dp[i][j] = nums[i];
            }
        }
        for (int i = 0; i < queriesCount; i++) {
            int x = queries[i][0], y = queries[i][1];
            if (y >= sqrt) {
                long sum = 0;
                while (x < length) {
                    sum = (sum + nums[x]) % MODULO;
                    x += y;
                }
                answer[i] = (int) sum;
            } else
                answer[i] = (int) dp[x][y];
        }
        return answer;
    }
}
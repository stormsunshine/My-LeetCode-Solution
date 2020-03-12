class Solution {
    public int knightDialer(int N) {
        final int MODULO = 1000000007;
        Map<Integer, int[]> adjacentMap = new HashMap<Integer, int[]>();
        adjacentMap.put(0, new int[]{4, 6});
        adjacentMap.put(1, new int[]{6, 8});
        adjacentMap.put(2, new int[]{7, 9});
        adjacentMap.put(3, new int[]{4, 8});
        adjacentMap.put(4, new int[]{0, 3, 9});
        adjacentMap.put(5, new int[0]);
        adjacentMap.put(6, new int[]{0, 1, 7});
        adjacentMap.put(7, new int[]{2, 6});
        adjacentMap.put(8, new int[]{1, 3});
        adjacentMap.put(9, new int[]{2, 4});
        int[][] dp = new int[N][10];
        for (int i = 0; i < 10; i++)
            dp[0][i] = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                int[] adjacents = adjacentMap.get(j);
                for (int adjacent : adjacents)
                    dp[i][j] = (dp[i][j] + dp[i - 1][adjacent]) % MODULO;
            }
        }
        int sum = 0;
        for (int i = 0; i < 10; i++)
            sum = (sum + dp[N - 1][i]) % MODULO;
        return sum;
    }
}
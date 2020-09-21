class Solution {
    public int connectTwoGroups(List<List<Integer>> cost) {
        int size1 = cost.size(), size2 = cost.get(0).size();
        int[][] costMatrix = new int[size1][1 << size2];
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < 1 << size2; j++) {
                int sum = 0;
                for (int k = 0; k < size2; k++) {
                    if ((j & (1 << k)) > 0)
                        sum += cost.get(i).get(k);
                }
                costMatrix[i][j] = sum;
            }
        }
        int[][] dp = new int[size1][1 << size2];
        for (int i = 1; i < size1; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[0] = costMatrix[0];
        for (int i = 1; i < size1; i++) {
            for (int j = 1; j < 1 << size2; j++) {
                for (int k = 0; k < size2; k++)
                    dp[i][j | (1 << k)] = Math.min(dp[i][j | (1 << k)], dp[i - 1][j] + cost.get(i).get(k));
                int rest = (1 << size2) - 1 - j;
                for (int k = rest; k >= 1; k = rest & (k - 1))
                    dp[i][j | k] = Math.min(dp[i][j | k], dp[i - 1][j] + costMatrix[i][k]);
            }
        }
        return dp[size1 - 1][(1 << size2) - 1];
    }
}
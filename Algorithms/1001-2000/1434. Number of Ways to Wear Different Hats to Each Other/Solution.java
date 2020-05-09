class Solution {
    public int numberWays(List<List<Integer>> hats) {
        final int MODULO = 1000000007;
        int peopleCount = hats.size();
        int hatsCount = 40;
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < peopleCount; i++) {
            List<Integer> curHats = hats.get(i);
            for (int hat : curHats) {
                List<Integer> list = map.getOrDefault(hat, new ArrayList<Integer>());
                list.add(i);
                map.put(hat, list);
            }
        }
        int[][] dp = new int[hatsCount + 1][1 << peopleCount];
        dp[0][0] = 1;
        for (int i = 1; i <= hatsCount; i++) {
            for (int j = 0; j < 1 << peopleCount; j++)
                dp[i][j] = dp[i - 1][j];
            if (map.containsKey(i)) {
                List<Integer> list = map.get(i);
                for (int j = 0; j < 1 << peopleCount; j++) {
                    for (int k : list) {
                        if ((j & (1 << k)) == 1 << k)
                            dp[i][j] = (dp[i][j] + dp[i - 1][j - (1 << k)]) % MODULO;
                    }
                }
            }
        }
        return dp[hatsCount][(1 << peopleCount) - 1];
    }
}
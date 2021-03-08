class Solution {
    public int minChanges(int[] nums, int k) {
        final int INF = 0x3f3f3f3f;
        final int MAX = 1 << 10;
        int length = nums.length;
        Map<Integer, Integer>[] groups = new Map[k];
        for (int i = 0; i < k; i++)
            groups[i] = new HashMap<Integer, Integer>();
        int[] size = new int[k];
        for (int i = 0; i < k; i++) {
            for (int j = i; j < length; j += k) {
                groups[i].put(nums[j], groups[i].getOrDefault(nums[j], 0) + 1);
                size[i]++;
            }
        }
        int[][] dp = new int[k + 1][MAX];
        Arrays.fill(dp[0], INF);
        dp[0][0] = 0;
        for (int i = 0; i < k; i++) {
            int low = Arrays.stream(dp[i]).min().getAsInt();
            Arrays.fill(dp[i + 1], low + size[i]);
            for (int j = 0; j < MAX; j++) {
                if (dp[i][j] != INF) {
                    for (Map.Entry<Integer, Integer> entry : groups[i].entrySet()) {
                        int key = entry.getKey(), value = entry.getValue();
                        int next = key ^ j;
                        dp[i + 1][next] = Math.min(dp[i + 1][next], dp[i][j] + size[i] - value);
                    }
                }
            }
        }
        return dp[k][0];
    }
}
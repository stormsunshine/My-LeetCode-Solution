class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        List<Integer> path = new ArrayList<Integer>();
        int length = A.length;
        int[] dp = new int[length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        if (A[length - 1] != -1)
            dp[length - 1] = A[length - 1];
        int[] next = new int[length];
        Arrays.fill(next, length);
        for (int i = length - 2; i >= 0; i--) {
            if (A[i] == -1)
                continue;
            int start = i + 1, end = Math.min(i + B, length - 1);
            for (int j = start; j <= end; j++) {
                if (dp[j] == Integer.MAX_VALUE)
                    continue;
                if (dp[j] + A[i] < dp[i]) {
                    dp[i] = dp[j] + A[i];
                    next[i] = j;
                }
            }
        }
        if (dp[0] == Integer.MAX_VALUE)
            return path;
        int index = 0;
        while (index < length) {
            path.add(index + 1);
            index = next[index];
        }
        return path;
    }
}
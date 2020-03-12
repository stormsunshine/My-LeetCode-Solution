class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] envelope1, int[] envelope2) {
                if (envelope1[0] != envelope2[0])
                    return envelope1[0] - envelope2[0];
                else
                    return envelope1[1] - envelope2[1];
            }
        });
        int length = envelopes.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < length; i++) {
            int[] envelope = envelopes[i];
            for (int j = 0; j < i; j++) {
                if (envelope[0] > envelopes[j][0] && envelope[1] > envelopes[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int maxEnvelopes = 1;
        for (int num : dp)
            maxEnvelopes = Math.max(maxEnvelopes, num);
        return maxEnvelopes;
    }
}
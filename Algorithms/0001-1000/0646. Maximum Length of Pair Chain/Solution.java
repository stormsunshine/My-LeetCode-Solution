class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                if (pair1[0] != pair2[0])
                    return pair1[0] - pair2[0];
                else
                    return pair1[1] - pair2[1];
            }
        });
        int length = pairs.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < length; i++) {
            int[] curPair = pairs[i];
            for (int j = 0; j < i; j++) {
                int[] prevPair = pairs[j];
                if (prevPair[1] < curPair[0])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int max = 1;
        for (int num : dp)
            max = Math.max(max, num);
        return max;
    }
}
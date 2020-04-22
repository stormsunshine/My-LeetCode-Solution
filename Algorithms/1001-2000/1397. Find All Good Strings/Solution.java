class Solution {
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        int length = evil.length();
        int[][][] dp = new int[n][length][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < 4; k++)
                    dp[i][j][k] = -1;
            }
        }
        int[][] transfers = new int[length][26];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 26; j++)
                transfers[i][j] = -1;
        }
        int[] fails = new int[length];
        for (int i = 1; i < length; i++) {
            int state = fails[i - 1];
            while (state > 0 && evil.charAt(state) != evil.charAt(i))
                state = fails[state - 1];
            if (evil.charAt(state) == evil.charAt(i))
                fails[i] = state + 1;
        }
        return depthFirstSearch(n, s1, s2, evil, dp, transfers, fails, 0, 0, 3);
    }

    public int depthFirstSearch(int n, String s1, String s2, String evil, int[][][] dp, int[][] transfers, int[] fails, int index, int state, int bound) {
        final int MODULO = 1000000007;
        int length = evil.length();
        if (state == length)
            return 0;
        if (index == n)
            return 1;
        if (dp[index][state][bound] >= 0)
            return dp[index][state][bound];
        dp[index][state][bound] = 0;
        char low = ((bound & 1) > 0) ? s1.charAt(index) : 'a';
        char high = ((bound & 2) > 0) ? s2.charAt(index) : 'z';
        for (char c = low; c <= high; c++) {
            int nextState = getTransfer(evil, transfers, fails, state, c);
            int nextBound = 0;
            if ((bound & 1) > 0 && c == s1.charAt(index))
                nextBound++;
            if ((bound & 2) > 0 && c == s2.charAt(index))
                nextBound += 2;
            dp[index][state][bound] = (dp[index][state][bound] + depthFirstSearch(n, s1, s2, evil, dp, transfers, fails, index + 1, nextState, nextBound)) % MODULO;
        }
        return dp[index][state][bound];
    }

    public int getTransfer(String evil, int[][] transfers, int[] fails, int state, char letter) {
        int letterIndex = letter - 'a';
        if (transfers[state][letterIndex] >= 0)
            return transfers[state][letterIndex];
        while (state > 0 && evil.charAt(state) != letter)
            state = fails[state - 1];
        int transfer = evil.charAt(state) == letter ? state + 1 : 0;
        transfers[state][letterIndex] = transfer;
        return transfer;
    }
}
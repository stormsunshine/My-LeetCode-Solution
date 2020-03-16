class Solution {
    public int minDeletionSize(String[] A) {
        int rows = A.length, columns = A[0].length();
        int[] dp = new int[columns];
        Arrays.fill(dp, 1);
        for (int i = columns - 2; i >= 0; i--) {
            for (int j = i + 1; j < columns; j++) {
                boolean flag = true;
                for (int k = 0; k < rows; k++) {
                    String str = A[k];
                    if (str.charAt(i) > str.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
        }
        int remain = 0;
        for (int num : dp)
            remain = Math.max(remain, num);
        return columns - remain;
    }
}
class Solution {
    public String largestNumber(int[] cost, int target) {
        String[][] dp = new String[target + 1][9];
        for (int i = 0; i < 9; i++)
            dp[0][i] = "";
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < 9; j++) {
                int digit = j + 1;
                int currCost = cost[j];
                if (currCost <= i) {
                    int prevCost = i - currCost;
                    boolean flag = false;
                    String prevStr = "";
                    for (int k = 0; k < 9; k++) {
                        if (dp[prevCost][k] != null) {
                            flag = true;
                            prevStr = max(prevStr, dp[prevCost][k]);
                        }
                    }
                    if (flag) {
                        StringBuffer sb = new StringBuffer(prevStr).append(digit);
                        dp[i][j] = sb.toString();
                    }
                }
            }
        }
        String largestNumber = "0";
        for (int i = 0; i < 9; i++) {
            if (dp[target][i] != null)
                largestNumber = max(largestNumber, dp[target][i]);
        }
        return largestNumber;
    }

    public String max(String str1, String str2) {
        if (str1.length() != str2.length())
            return str1.length() > str2.length() ? str1 : str2;
        else
            return str1.compareTo(str2) > 0 ? str1 : str2;
    }
}
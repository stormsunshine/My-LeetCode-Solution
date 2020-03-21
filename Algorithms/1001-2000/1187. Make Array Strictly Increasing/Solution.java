class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int num : arr2)
            set.add(num);
        int length = arr1.length;
        int[][] dp = new int[length][length + 1];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= length; j++)
                dp[i][j] = Integer.MAX_VALUE;
        }
        dp[0][0] = arr1[0];
        dp[0][1] = set.first();
        for (int i = 1; i < length; i++) {
            if (arr1[i] > dp[i - 1][0])
                dp[i][0] = arr1[i];
            for (int j = 1; j <= i; j++) {
                Integer nextNum = set.higher(dp[i - 1][j - 1]);
                if (nextNum != null)
                    dp[i][j] = nextNum;
                if (arr1[i] > dp[i - 1][j])
                    dp[i][j] = Math.min(dp[i][j], arr1[i]);
            }
            Integer nextNum = set.higher(dp[i - 1][i]);
            if (nextNum != null)
                dp[i][i + 1] = nextNum;
        }
        for (int i = 0; i <= length; i++) {
            if (dp[length - 1][i] != Integer.MAX_VALUE)
                return i;
        }
        return -1;
    }
}
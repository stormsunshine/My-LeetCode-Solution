class Solution {
    public int minimumIncompatibility(int[] nums, int k) {
        int length = nums.length;
        int[] value = new int[1 << length];
        Arrays.fill(value, -1);
        int[] freq = new int[length + 1];
        for (int i = 0; i < 1 << length; i++) {
            if (Integer.bitCount(i) == length / k) {
                for (int j = 0; j < length; j++) {
                    if ((i & (1 << j)) != 0)
                        freq[nums[j]]++;
                }
                boolean flag = true;
                for (int j = 1; j <= length; j++) {
                    if (freq[j] > 1) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
                    for (int j = 1; j <= length; ++j) {
                        if (freq[j] > 0) {
                            low = Math.min(low, j);
                            high = Math.max(high, j);
                        }
                    }
                    value[i] = high - low;
                }
                for (int j = 0; j < length; ++j) {
                    if ((i & (1 << j)) != 0) {
                        --freq[nums[j]];
                    }
                }
            }
        }
        int[] dp = new int[1 << length];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < 1 << length; i++) {
            if (Integer.bitCount(i) % (length / k) == 0) {
                for (int j = i; j != 0; j = (j - 1) & i) {
                    if (value[j] != -1 && dp[i ^ j] != -1) {
                        if (dp[i] == -1)
                            dp[i] = dp[i ^ j] + value[j];
                        else
                            dp[i] = Math.min(dp[i], dp[i ^ j] + value[j]);
                    }
                }
            }
        }
        return dp[(1 << length) - 1];
    }
}
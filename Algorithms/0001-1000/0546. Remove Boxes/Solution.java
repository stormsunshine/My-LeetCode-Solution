class Solution {
    public int removeBoxes(int[] boxes) {
        if (boxes == null || boxes.length == 0)
            return 0;
        int length = boxes.length;
        int[][][] dp = new int[length][length][length];
        return getPoints(boxes, dp, 0, length - 1, 0);
    }

    public int getPoints(int[] boxes, int[][][] dp, int low, int high, int count) {
        if (low > high)
            return 0;
        if (dp[low][high][count] != 0)
            return dp[low][high][count];
        while (low < high && boxes[high] == boxes[high - 1]) {
            high--;
            count++;
        }
        dp[low][high][count] = getPoints(boxes, dp, low, high - 1, 0) + (count + 1) * (count + 1);
        for (int i = low; i < high; i++) {
            if (boxes[i] == boxes[high])
                dp[low][high][count] = Math.max(dp[low][high][count], getPoints(boxes, dp, low, i, count + 1) + getPoints(boxes, dp, i + 1, high - 1, 0));
        }
        return dp[low][high][count];
    }
}
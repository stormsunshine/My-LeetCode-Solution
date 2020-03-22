class Solution {
    public int maxSizeSlices(int[] slices) {
        int length = slices.length;
        int counts = length / 3;
        int[][] dp1 = new int[counts][length - 1];
        int[][] dp2 = new int[counts][length - 1];
        for (int i = 0; i < length - 1; i++) {
            dp1[0][i] = slices[i];
            dp2[0][i] = slices[i + 1];
        }
        for (int i = 1; i < counts; i++) {
            dp1[i][0] = slices[0];
            dp1[i][1] = slices[1];
            int max1 = dp1[i][0];
            for (int j = 2; j < length - 1; j++) {
                dp1[i][j] = max1 + slices[j];
                max1 = Math.max(max1, dp1[i - 1][j - 1]);
            }
            dp2[i][0] = slices[1];
            dp2[i][1] = slices[2];
            int max2 = dp2[i][0];
            for (int j = 2; j < length - 1; j++) {
                dp2[i][j] = max2 + slices[j + 1];
                max2 = Math.max(max2, dp2[i - 1][j - 1]);
            }
        }
        int max = Math.max(dp1[counts - 1][0], dp2[counts - 1][0]);
        for (int i = 0; i < length - 1; i++) {
            max = Math.max(max, dp1[counts - 1][i]);
            max = Math.max(max, dp2[counts - 1][i]);
        }
        return max;
    }
}
class Solution {
    public int maxJumps(int[] arr, int d) {
        int length = arr.length;
        int[][] indexHeightArray = new int[length][2];
        for (int i = 0; i < length; i++) {
            indexHeightArray[i][0] = i;
            indexHeightArray[i][1] = arr[i];
        }
        Arrays.sort(indexHeightArray, new Comparator<int[]>() {
            public int compare(int[] indexHeight1, int[] indexHeight2) {
                return indexHeight1[1] - indexHeight2[1];
            }
        });
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < length; i++) {
            int[] indexHeight = indexHeightArray[i];
            int startIndex = indexHeight[0];
            int curHeight = indexHeight[1];
            int leftMost = Math.max(startIndex - d, 0);
            int rightMost = Math.min(startIndex + d, length - 1);
            for (int j = startIndex - 1; j >= leftMost; j--) {
                if (arr[j] >= curHeight)
                    break;
                dp[startIndex] = Math.max(dp[startIndex], dp[j] + 1);
            }
            for (int j = startIndex + 1; j <= rightMost; j++) {
                if (arr[j] >= curHeight)
                    break;
                dp[startIndex] = Math.max(dp[startIndex], dp[j] + 1);
            }
        }
        int maxJump = 0;
        for (int jump : dp)
            maxJump = Math.max(maxJump, jump);
        return maxJump;
    }
}
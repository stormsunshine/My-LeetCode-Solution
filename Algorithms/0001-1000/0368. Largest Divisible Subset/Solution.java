class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int[][] dp = new int[length][2];
        for (int i = 0; i < length; i++) {
            dp[i][0] = 1;
            dp[i][1] = -1;
        }
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            int maxPrevSize = 0;
            int maxPrevIndex = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (num % nums[j] == 0) {
                    if (dp[j][0] > maxPrevSize) {
                        maxPrevSize = dp[j][0];
                        maxPrevIndex = j;
                    }
                }
            }
            dp[i][0] = maxPrevSize + 1;
            dp[i][1] = maxPrevIndex;
        }
        int maxSize = 0;
        int maxEndIndex = -1;
        for (int i = 0; i < length; i++) {
            if (dp[i][0] > maxSize) {
                maxSize = dp[i][0];
                maxEndIndex = i;
            }
        }
        int curIndex = maxEndIndex;
        List<Integer> largestList = new ArrayList<Integer>();
        while (curIndex >= 0) {
            largestList.add(nums[curIndex]);
            curIndex = dp[curIndex][1];
        }
        Collections.reverse(largestList);
        return largestList;
    }
}
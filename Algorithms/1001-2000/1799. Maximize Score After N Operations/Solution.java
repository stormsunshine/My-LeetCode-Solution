class Solution {
    int maxScore = 0;
    Map<Long, Integer> map = new HashMap<Long, Integer>();

    public int maxScore(int[] nums) {
        int length = nums.length;
        int[] groups = new int[length];
        groups[0] = 1;
        for (int i = 1; i < length; i++) {
            groups[i] = 1;
            backtrack(nums, groups, 1, 2, nums.length / 2);
            groups[i] = 0;
        }
        return maxScore;
    }

    public void backtrack(int[] nums, int[] groups, int startIndex, int curr, int n) {
        int length = nums.length;
        if (curr > n) {
            int[][] groupsNums = new int[length][2];
            for (int i = 0; i < length; i++) {
                groupsNums[i][0] = groups[i];
                groupsNums[i][1] = nums[i];
            }
            Arrays.sort(groupsNums, new Comparator<int[]>() {
                public int compare(int[] groupNum1, int[] groupNum2) {
                    return groupNum1[0] - groupNum2[0];
                }
            });
            int[] gcds = new int[n];
            for (int i = 0; i < length; i += 2) {
                int gcd = gcd(groupsNums[i][1], groupsNums[i + 1][1]);
                gcds[i / 2] = gcd;
            }
            Arrays.sort(gcds);
            int score = 0;
            for (int i = 0; i < n; i++)
                score += (i + 1) * gcds[i];
            maxScore = Math.max(maxScore, score);
            return;
        }
        for (int i = startIndex; i < length; i++) {
            if (groups[i] == 0) {
                groups[i] = curr;
                for (int j = i + 1; j < length; j++) {
                    if (groups[j] == 0) {
                        groups[j] = curr;
                        backtrack(nums, groups, i + 1, curr + 1, n);
                        groups[j] = 0;
                    }
                }
                groups[i] = 0;
            }
        }
    }

    public int gcd(int num1, int num2) {
        return num2 == 0 ? num1 : gcd(num2, num1 % num2);
    }
}
class Solution {
    final int MODULO = 1000000007;

    public int numOfWays(int[] nums) {
        int length = nums.length;
        int[][] combinations = calculateCombinations(length);
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < length; i++)
            list.add(nums[i]);
        int ways = getWays(list, combinations);
        return ways - 1;
    }

    public int[][] calculateCombinations(int n) {
        int[][] combinations = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            combinations[i][0] = 1;
            for (int j = 1; j <= i; j++)
                combinations[i][j] = (combinations[i - 1][j] + combinations[i - 1][j - 1]) % MODULO;
        }
        return combinations;
    }

    public int getWays(List<Integer> list, int[][] combinations) {
        if (list.isEmpty())
            return 1;
        List<Integer> leftList = new ArrayList<Integer>();
        List<Integer> rightList = new ArrayList<Integer>();
        int root = list.get(0);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            int num = list.get(i);
            if (num < root)
                leftList.add(num);
            else
                rightList.add(num);
        }
        int leftWays = getWays(leftList, combinations);
        int rightWays = getWays(rightList, combinations);
        long ways = (long) combinations[size - 1][leftList.size()] * leftWays % MODULO * rightWays % MODULO;
        return (int) ways;
    }
}
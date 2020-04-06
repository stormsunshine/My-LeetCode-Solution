class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, columns = matrix[0].length;
        int maxSum = Integer.MIN_VALUE;
        int[][] sums = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            sums[i][0] = matrix[i][0];
            for (int j = 1; j < columns; j++)
                sums[i][j] = sums[i][j - 1] + matrix[i][j];
        }
        for (int left = 0; left < columns; left++) {
            for (int right = left; right < columns; right++) {
                int curMaxSum = Integer.MIN_VALUE;
                int curSum = 0;
                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                for (int i = 0; i < rows; i++) {
                    curSum += sums[i][right];
                    if (left > 0)
                        curSum -= sums[i][left - 1];
                    Integer ceil = set.ceiling(curSum - k);
                    if (ceil != null)
                        curMaxSum = Math.max(curMaxSum, curSum - ceil);
                    set.add(curSum);
                }
                maxSum = Math.max(maxSum, curMaxSum);
            }
        }
        return maxSum;
    }
}
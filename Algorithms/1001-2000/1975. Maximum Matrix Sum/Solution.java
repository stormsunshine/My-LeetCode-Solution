class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int minPositive = Integer.MAX_VALUE;
        int minNegative = Integer.MIN_VALUE;
        int positiveCount = 0, negativeCount = 0, zeroCount = 0;
        int side = matrix.length;
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                int num = matrix[i][j];
                sum += Math.abs(num);
                if (num > 0) {
                    minPositive = Math.min(minPositive, num);
                    positiveCount++;
                } else if (num < 0) {
                    minNegative = Math.max(minNegative, num);
                    negativeCount++;
                } else
                    zeroCount++;
            }
        }
        if (zeroCount > 0 || negativeCount % 2 == 0)
            return sum;
        if (positiveCount == 0)
            return sum += minNegative * 2;
        int minPositiveAbs = minPositive, minNegativeAbs = -minNegative;
        sum -= Math.min(minPositiveAbs, minNegativeAbs) * 2;
        return sum;
    }
}
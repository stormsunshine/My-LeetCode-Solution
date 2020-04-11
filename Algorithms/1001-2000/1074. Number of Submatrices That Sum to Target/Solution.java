class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int rows = matrix.length, columns = matrix[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            int[] sums = new int[columns];
            for (int j = i; j < rows; j++) {
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                map.put(0, 1);
                int sum = 0;
                for (int k = 0; k < columns; k++) {
                    sums[k] += matrix[j][k];
                    sum += sums[k];
                    count += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return count;
    }
}
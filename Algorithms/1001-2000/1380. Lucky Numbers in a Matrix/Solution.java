class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int rows = matrix.length, columns = matrix[0].length;
        int[] mins = new int[rows];
        for (int i = 0; i < rows; i++) {
            int min = matrix[i][0];
            int minColumn = 0;
            for (int j = 1; j < columns; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minColumn = j;
                }
            }
            mins[i] = minColumn;
        }
        List<Integer> luckyNumbers = new ArrayList<Integer>();
        for (int i = 0; i < rows; i++) {
            int minColumn = mins[i];
            int min = matrix[i][minColumn];
            boolean flag = true;
            for (int j = 0; j < rows; j++) {
                if (j == i)
                    continue;
                else if (matrix[j][minColumn] > min) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                luckyNumbers.add(min);
        }
        return luckyNumbers;
    }
}
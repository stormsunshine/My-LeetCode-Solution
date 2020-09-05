class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int side = mat.length;
        for (int i = 0; i < side; i++) {
            sum += mat[i][i];
            sum += mat[i][side - 1 - i];
        }
        if (side % 2 != 0)
            sum -= mat[side / 2][side / 2];
        return sum;
    }
}
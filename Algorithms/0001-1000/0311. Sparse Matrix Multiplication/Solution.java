class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int rows1 = A.length, columns1 = A[0].length, rows2 = B.length, columns2 = B[0].length;
        Set<Integer> zeroRowsA = new HashSet<Integer>();
        Set<Integer> zeroColumnsB = new HashSet<Integer>();
        for (int i = 0; i < rows1; i++) {
            boolean flag = true;
            for (int j = 0; j < columns1; j++) {
                if (A[i][j] != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                zeroRowsA.add(i);
        }
        for (int i = 0; i < columns2; i++) {
            boolean flag = true;
            for (int j = 0; j < rows2; j++) {
                if (B[j][i] != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                zeroColumnsB.add(i);
        }
        int[][] mul = new int[rows1][columns2];
        for (int i = 0; i < rows1; i++) {
            if (zeroRowsA.contains(i))
                continue;
            for (int j = 0; j < columns2; j++) {
                if (zeroColumnsB.contains(j))
                    continue;
                for (int k = 0; k < columns1; k++) {
                    if (A[i][k] == 0 || B[k][j] == 0)
                        continue;
                    mul[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return mul;
    }
}
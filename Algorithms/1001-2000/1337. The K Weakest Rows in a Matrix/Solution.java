class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        if (mat == null || mat.length == 0 || mat[0].length == 0)
            return new int[0];
        int rows = mat.length, columns = mat[0].length;
        int[][] indexCount = new int[rows][2];
        for (int i = 0; i < rows; i++) {
            int rowCount = 0;
            for (int j = 0; j < columns; j++) {
                if (mat[i][j] == 1)
                    rowCount++;
                else
                    break;
            }
            indexCount[i][0] = i;
            indexCount[i][1] = rowCount;
        }
        Arrays.sort(indexCount, new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2) {
                if (array1[1] != array2[1])
                    return array1[1] - array2[1];
                else
                    return array1[0] - array2[0];
            }
        });
        int[] kWeakest = new int[k];
        for (int i = 0; i < k; i++)
            kWeakest[i] = indexCount[i][0];
        return kWeakest;
    }
}
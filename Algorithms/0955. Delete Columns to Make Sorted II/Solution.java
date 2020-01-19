class Solution {
    public int minDeletionSize(String[] A) {
        int rows = A.length, columns = A[0].length();
        if (rows < 2)
            return 0;
        int deletionSize = 0;
        int[] differences = new int[rows - 1];
        for (int i = 0; i < columns; i++) {
            int[] curDifferences = new int[rows - 1];
            boolean deleteFlag = false;
            for (int j = 0; j < rows - 1; j++) {
                if (differences[j] == 0) {
                    if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                        deletionSize++;
                        deleteFlag = true;
                        break;
                    } else if (A[j].charAt(i) < A[j + 1].charAt(i))
                        curDifferences[j] = 1;
                }
            }
            if (!deleteFlag) {
                for (int j = 0; j < rows - 1; j++)
                    differences[j] = Math.max(differences[j], curDifferences[j]);
            }
        }
        return deletionSize;
    }
}
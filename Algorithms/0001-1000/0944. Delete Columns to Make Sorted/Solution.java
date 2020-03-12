class Solution {
    public int minDeletionSize(String[] A) {
        int rows = A.length, columns = A[0].length();
        int deletionSize = 0;
        for (int i = 0; i < columns; i++) {
            for (int j = 1; j < rows; j++) {
                if (A[j].charAt(i) < A[j - 1].charAt(i)) {
                    deletionSize++;
                    break;
                }
            }
        }
        return deletionSize;
    }
}
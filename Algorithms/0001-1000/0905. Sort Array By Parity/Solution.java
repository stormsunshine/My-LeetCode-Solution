class Solution {
    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length < 2)
            return A;
        int length = A.length;
        for (int i = 1; i < length; i++) {
            int num = A[i];
            if (num % 2 != 0)
                continue;
            int insertIndex = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] % 2 == 0) {
                    insertIndex = j + 1;
                    break;
                } else
                    A[j + 1] = A[j];
            }
            A[insertIndex] = num;
        }
        return A;
    }
}
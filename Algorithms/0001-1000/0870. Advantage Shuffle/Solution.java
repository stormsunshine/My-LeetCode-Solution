class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int length = A.length;
        int[][] arrayA2D = new int[length][2];
        int[][] arrayB2D = new int[length][2];
        for (int i = 0; i < length; i++) {
            arrayB2D[i][0] = B[i];
            arrayB2D[i][1] = i;
        }
        Arrays.sort(arrayB2D, new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2) {
                return array1[0] - array2[0];
            }
        });
        for (int i = 0; i < length; i++)
            arrayA2D[i][1] = arrayB2D[i][1];
        Arrays.sort(A);
        int index = 0;
        for (int i = 0; i < length; i++) {
            int num = A[i];
            if (num > arrayB2D[index][0]) {
                arrayA2D[index][0] = num;
                index++;
                A[i] = -1;
            }
        }
        for (int i = 0; i < length; i++) {
            int num = A[i];
            if (num >= 0) {
                arrayA2D[index][0] = num;
                index++;
            }
        }
        Arrays.sort(arrayA2D, new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2) {
                return array1[1] - array2[1];
            }
        });
        int[] permutation = new int[length];
        for (int i = 0; i < length; i++)
            permutation[i] = arrayA2D[i][0];
        return permutation;
    }
}
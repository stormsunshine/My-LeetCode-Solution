class Solution {
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0)
            return A;
        int length = A.length;
        int minAbs = Integer.MAX_VALUE;
        int startIndex = -1;
        for (int i = 0; i < length; i++) {
            int num = A[i];
            int abs = Math.abs(num);
            if (abs < minAbs) {
                minAbs = abs;
                startIndex = i;
            }
            if (num > minAbs)
                break;
        }
        int[] squares = new int[length];
        squares[0] = minAbs * minAbs;
        int index = 1;
        int index1 = startIndex - 1, index2 = startIndex + 1;
        while (index1 >= 0 && index2 < length) {
            if (Math.abs(A[index1]) <= Math.abs(A[index2])) {
                squares[index] = A[index1] * A[index1];
                index1--;
            } else {
                squares[index] = A[index2] * A[index2];
                index2++;
            }
            index++;
        }
        while (index1 >= 0) {
            squares[index] = A[index1] * A[index1];
            index++;
            index1--;
        }
        while (index2 < length) {
            squares[index] = A[index2] * A[index2];
            index++;
            index2++;
        }
        return squares;
    }
}
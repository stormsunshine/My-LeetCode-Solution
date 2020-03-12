class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int length = A.length;
        for (int i = 0; i < length && K > 0; i++) {
            if (A[i] < 0) {
                A[i] = -A[i];
                K--;
            } else if (K % 2 != 0) {
                if (i == 0)
                    A[i] = -A[i];
                else {
                    if (A[i - 1] <= A[i])
                        A[i - 1] = -A[i - 1];
                    else
                        A[i] = -A[i];
                }
                break;
            }
        }
        int sum = 0;
        for (int num : A)
            sum += num;
        return sum;
    }
}
class Solution {
    public int sumSubseqWidths(int[] A) {
        final int MODULO = 1000000007;
        Arrays.sort(A);
        int length = A.length;
        long[] pow2 = new long[length];
        pow2[0] = 1;
        for (int i = 1; i < length; i++)
            pow2[i] = pow2[i - 1] * 2 % MODULO;
        long sum = 0;
        for (int i = 0; i < length; i++)
            sum = (sum + (pow2[i] - pow2[length - 1 - i]) * A[i]) % MODULO;
        return (int) sum;
    }
}
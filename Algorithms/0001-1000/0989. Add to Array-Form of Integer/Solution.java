class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> sum = new ArrayList<Integer>();
        int length = A.length;
        A[length - 1] += K;
        for (int i = length - 1; i > 0; i--) {
            int curNum = A[i];
            if (curNum >= 10) {
                A[i - 1] += curNum / 10;
                A[i] %= 10;
            }
        }
        char[] highestArray = String.valueOf(A[0]).toCharArray();
        for (char c : highestArray) {
            int digit = c - '0';
            sum.add(digit);
        }
        for (int i = 1; i < length; i++)
            sum.add(A[i]);
        return sum;
    }
}
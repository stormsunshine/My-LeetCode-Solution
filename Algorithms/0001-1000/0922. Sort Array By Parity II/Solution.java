class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int length = A.length;
        int[] sorted = new int[length];
        int evenIndex = 0, oddIndex = 1;
        for (int i = 0; i < length; i++) {
            int num = A[i];
            if (num % 2 == 0) {
                sorted[evenIndex] = num;
                evenIndex += 2;
            } else {
                sorted[oddIndex] = num;
                oddIndex += 2;
            }
        }
        return sorted;
    }
}
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        for (int num : A)
            sumA += num;
        for (int num : B)
            sumB += num;
        int dif = (sumA - sumB) / 2;
        int[] swap = new int[2];
        for (int numA : A) {
            for (int numB : B) {
                if (numA - numB == dif) {
                    swap[0] = numA;
                    swap[1] = numB;
                    return swap;
                }
            }
        }
        return swap;
    }
}
class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int xor1 = 0, xor2 = 0;
        for (int num : arr1)
            xor1 ^= num;
        for (int num : arr2)
            xor2 ^= num;
        return xor1 & xor2;
    }
}
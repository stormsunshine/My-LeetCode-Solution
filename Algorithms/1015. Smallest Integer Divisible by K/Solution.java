class Solution {
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0)
            return -1;
        int value = 1;
        int length = 1;
        while (value % K != 0) {
            value = value % K * 10 + 1;
            length++;
        }
        return length;
    }
}
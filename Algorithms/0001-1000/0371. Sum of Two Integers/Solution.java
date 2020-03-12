class Solution {
    public int getSum(int a, int b) {
        while (a != 0) {
            int temp = a ^ b;
            a = (a & b) << 1;
            b = temp;
        }
        return b;
    }
}
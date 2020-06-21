class Solution {
    public int xorOperation(int n, int start) {
        int end = start + 2 * (n - 1);
        int xor = 0;
        for (int i = start; i <= end; i += 2)
            xor ^= i;
        return xor;
    }
}
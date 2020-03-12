class Solution {
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 0; i <= num; i++)
            bits[i] = Integer.bitCount(i);
        return bits;
    }
}
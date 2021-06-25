class Solution {
    public boolean nimGame(int[] piles) {
        int xor = 0;
        for (int pile : piles)
            xor ^= pile;
        return xor != 0;
    }
}
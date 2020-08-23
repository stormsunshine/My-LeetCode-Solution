class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int length = piles.length;
        int rounds = length / 3;
        int maxCoins = 0;
        int index = length - 2;
        for (int i = 0; i < rounds; i++) {
            maxCoins += piles[index];
            index -= 2;
        }
        return maxCoins;
    }
}
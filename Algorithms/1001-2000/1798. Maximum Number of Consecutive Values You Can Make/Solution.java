class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        if (coins[0] > 1)
            return 1;
        int curr = 1;
        int length = coins.length, index = 0;
        while (true) {
            if (index < length && coins[index] <= curr) {
                curr += coins[index];
                index++;
            } else
                break;
        }
        return curr;
    }
}
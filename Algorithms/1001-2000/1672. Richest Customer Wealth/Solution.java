class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        int rows = accounts.length;
        for (int i = 0; i < rows; i++) {
            int[] account = accounts[i];
            int sum = 0;
            for (int amount : account)
                sum += amount;
            maxWealth = Math.max(maxWealth, sum);
        }
        return maxWealth;
    }
}
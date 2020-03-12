class Solution {
    public int minCostToMoveChips(int[] chips) {
        int evenCount = 0, oddCount = 0;
        int length = chips.length;
        for (int i = 0; i < length; i++) {
            int chip = chips[i];
            if (chip % 2 == 0)
                evenCount++;
            else
                oddCount++;
        }
        return Math.min(evenCount, oddCount);
    }
}
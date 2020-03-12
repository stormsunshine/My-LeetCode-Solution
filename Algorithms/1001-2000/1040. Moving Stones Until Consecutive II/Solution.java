class Solution {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int length = stones.length;
        int max = stones[length - 1] - stones[0] + 1 - length;
        max -= Math.min(stones[1] - stones[0] - 1, stones[length - 1] - stones[length - 2] - 1);
        int min = max;
        int j = 0;
        for (int i = 0; i < length; i++) {
            while (j + 1 < length && stones[j + 1] - stones[i] + 1 <= length)
                j++;
            int cost = length - (j - i + 1);
            if (j - i + 1 == length - 1 && stones[j] - stones[i] + 1 == length - 1)
                cost = 2;
            min = Math.min(min, cost);
        }
        return new int[]{min, max};
    }
}
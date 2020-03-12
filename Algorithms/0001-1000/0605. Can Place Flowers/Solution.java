class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        List<Integer> emptyCounts = new ArrayList<Integer>();
        int prevEmpty = -1;
        int emptyCount = 1;
        int length = flowerbed.length;
        for (int i = 0; i <= length; i++) {
            int num = i < length ? flowerbed[i] : 0;
            if (num == 0) {
                emptyCount++;
                prevEmpty = i;
            } else {
                if (emptyCount > 0) {
                    emptyCounts.add(emptyCount);
                    emptyCount = 0;
                }
            }
        }
        if (emptyCount > 0)
            emptyCounts.add(emptyCount);
        int maxFlowers = 0;
        for (int num : emptyCounts)
            maxFlowers += (num - 1) / 2;
        return maxFlowers >= n;
    }
}
class Solution {
    public int minimumBoxes(int n) {
        if (n <= 3)
            return n;
        int total = 0;
        int levelCount = 0;
        int currLevel = 0;
        while (total < n) {
            levelCount++;
            currLevel += levelCount;
            total += currLevel;
        }
        if (total == n)
            return currLevel;
        total -= currLevel;
        currLevel -= levelCount;
        int remain = n - total;
        int increase = findMin(remain);
        return currLevel + increase;
    }

    public int findMin(int remain) {
        int min = (int) Math.sqrt(remain * 2);
        while (min * (min + 1) / 2 < remain)
            min++;
        return min;
    }
}
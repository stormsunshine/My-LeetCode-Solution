class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        int totalCount = 10;
        int count = 9;
        int nextCount = 9;
        int upper = Math.min(n, 10);
        for (int i = 2; i <= upper; i++) {
            count *= nextCount;
            nextCount--;
            totalCount += count;
        }
        return totalCount;
    }
}
class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] sums = new int[50];
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = getSumOfDigits(i);
            sums[sum]++;
        }
        int maxCount = 0;
        for (int i = 0; i < 50; i++)
            maxCount = Math.max(maxCount, sums[i]);
        return maxCount;
    }

    public int getSumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
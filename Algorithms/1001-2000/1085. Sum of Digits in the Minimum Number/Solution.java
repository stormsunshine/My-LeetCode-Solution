class Solution {
    public int sumOfDigits(int[] A) {
        int min = Integer.MAX_VALUE;
        for (int num : A)
            min = Math.min(min, num);
        if (min == 0)
            return 1;
        int sum = 0;
        int temp = min;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return sum % 2 == 0 ? 1 : 0;
    }
}
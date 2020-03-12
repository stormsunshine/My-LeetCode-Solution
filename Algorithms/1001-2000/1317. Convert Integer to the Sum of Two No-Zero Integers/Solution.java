class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] nums = new int[2];
        int upper = n / 2;
        for (int i = 1; i <= upper; i++) {
            int num2 = n - i;
            if (noZero(i) && noZero(num2)) {
                nums[0] = i;
                nums[1] = num2;
                break;
            }
        }
        return nums;
    }

    public boolean noZero(int num) {
        if (num <= 0)
            return false;
        while (num > 0) {
            int remainder = num % 10;
            if (remainder == 0)
                return false;
            num /= 10;
        }
        return true;
    }
}
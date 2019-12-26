class Solution {
    public boolean isGoodArray(int[] nums) {
        int length = nums.length;
        int gcd = nums[0];
        for (int i = 1; i < length; i++) {
            gcd = gcd(gcd, nums[i]);
            if (gcd == 1)
                return true;
        }
        return gcd == 1;
    }

    public int gcd(int num1, int num2) {
        if (num1 == 0 && num2 == 0)
            return 1;
        if (num1 == 1 || num2 == 1)
            return 1;
        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        while (num1 != 0 && num2 != 0) {
            num2 %= num1;
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        if (num1 == 0)
            return num2;
        else
            return num1;
    }
}
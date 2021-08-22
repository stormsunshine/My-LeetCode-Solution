class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int minNum = nums[0], maxNum = nums[nums.length - 1];
        return gcd(minNum, maxNum);
    }

    public int gcd(int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (b % a == 0)
            return a;
        return gcd(a, b % a);
    }
}
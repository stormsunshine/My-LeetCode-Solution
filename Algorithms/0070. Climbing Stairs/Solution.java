class Solution {
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        int prev2 = 1, prev1 = 2;
        int num = 0;
        for (int i = 3; i <= n; i++) {
            num = prev2 + prev1;
            prev2 = prev1;
            prev1 = num;
        }
        return num;
    }
}
class Solution {
    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int[] tribonacci = new int[n + 1];
        tribonacci[0] = 0;
        tribonacci[1] = 1;
        tribonacci[2] = 1;
        for (int i = 3; i <= n; i++)
            tribonacci[i] = tribonacci[i - 3] + tribonacci[i - 2] + tribonacci[i - 1];
        return tribonacci[n];
    }
}
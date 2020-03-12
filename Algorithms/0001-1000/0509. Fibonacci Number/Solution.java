class Solution {
    public int fib(int N) {
        if (N <= 1)
            return N;
        int prev2 = 0, prev1 = 1;
        int num = 1;
        int index = 2;
        while (index <= N) {
            num = prev2 + prev1;
            prev2 = prev1;
            prev1 = num;
            index++;
        }
        return num;
    }
}
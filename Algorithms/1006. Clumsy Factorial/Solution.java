class Solution {
    public int clumsy(int N) {
        if (N <= 3)
            return supplementary(N);
        int num = N;
        int factorial = supplementary(num);
        num = Math.max(num - 3, 0);
        factorial += num;
        num--;
        while (num > 0) {
            factorial -= supplementary(num);
            num = Math.max(num - 3, 0);
            factorial += num;
            num--;
        }
        return factorial;
    }

    public int supplementary(int num) {
        if (num <= 2)
            return num;
        else
            return num * (num - 1) / (num - 2);
    }
}
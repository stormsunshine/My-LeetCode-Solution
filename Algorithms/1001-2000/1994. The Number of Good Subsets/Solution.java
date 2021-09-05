class Solution {
    int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

    public int numberOfGoodSubsets(int[] nums) {
        final int MODULO = 1000000007;
        int length = nums.length;
        int[] states = new int[31];
        for (int i = 1; i <= 30; i++)
            states[i] = calculate(i);
        int[] f = new int[1 << 10];
        int[] g = new int[1 << 10];
        int[] counts = new int[31];
        for (int i = 0; i < length; i++)
            counts[nums[i]]++;
        if (counts[1] == length)
            return 0;
        f[0] = 1;
        for (int i = 2; i <= 30; i++) {
            int state = states[i];
            if (state == -1 || counts[i] == 0)
                continue;
            for (int j = 0; j < 1 << 10; j++)
                g[j] = f[j];
            for (int j = 0; j < 1 << 10; j++) {
                if (g[j] != 0 && (j & state) == 0) {
                    f[j ^ state] += (int) ((long) g[j] * counts[i] % MODULO);
                    f[j ^ state] %= MODULO;
                }
            }
        }
        int power = 1;
        for (int i = 0; i < counts[1]; i++)
            power = power * 2 % MODULO;
        long sum = 0;
        for (int i = 0; i < 1 << 10; i++)
            sum += f[i];
        sum += MODULO - 1;
        sum %= MODULO;
        sum = sum * power % MODULO;
        return (int) sum;
    }

    public int calculate(int num) {
        int state = 0;
        for (int i = 0; i < 10; i++) {
            if (num % primes[i] == 0) {
                if ((num / primes[i]) % primes[i] == 0)
                    return -1;
                state |= 1 << i;
            }
        }
        return state;
    }
}
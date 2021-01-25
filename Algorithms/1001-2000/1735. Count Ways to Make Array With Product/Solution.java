class Solution {
    int[] primes = new int[14];
    int[] exponents = new int[14];
    int index = 0;
    long[][] combinations = new long[11000][20];
    static final int MODULO = 1000000007;

    public int[] waysToFillArray(int[][] queries) {
        for (int i = 0; i < 10500; i++) {
            combinations[i][0] = 1;
            if (i < 15)
                combinations[i][i] = 1;
            int end = Math.min(i, 15);
            for (int j = 1; j < end; j++)
                combinations[i][j] = (combinations[i - 1][j - 1] + combinations[i - 1][j]) % MODULO;
        }
        int queriesCount = queries.length;
        int[] ways = new int[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            int n = queries[i][0], k = queries[i][1];
            long way = 1;
            fact(k);
            for (int j = 1; j <= index; j++)
                way = way * combinations[n + exponents[j] - 1][exponents[j]] % MODULO;
            ways[i] = (int) way;
        }
        return ways;
    }

    public void fact(int n) {
        index = 0;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                index++;
                primes[index] = i;
                exponents[index] = 0;
                while (n % i == 0) {
                    exponents[index]++;
                    n /= i;
                }
            }
        }
        if (n != 1) {
            index++;
            primes[index] = n;
            exponents[index] = 1;
        }
    }
}
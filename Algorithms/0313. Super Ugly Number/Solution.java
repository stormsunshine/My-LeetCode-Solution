class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        Arrays.sort(primes);
        int[] dp = new int[n];
        dp[0] = 1;
        int primesCount = primes.length;
        int[] pointers = new int[primesCount];
        for (int i = 1; i < n; i++) {
            int[] nums = new int[primesCount];
            for (int j = 0; j < primesCount; j++)
                nums[j] = dp[pointers[j]] * primes[j];
            int min = nums[0];
            for (int num : nums)
                min = Math.min(min, num);
            dp[i] = min;
            for (int j = 0; j < primesCount; j++) {
                if (min == nums[j])
                    pointers[j]++;
            }
        }
        return dp[n - 1];
    }
}
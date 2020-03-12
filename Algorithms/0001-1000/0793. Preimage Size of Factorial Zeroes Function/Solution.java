class Solution {
    public int preimageSizeFZF(int K) {
        long low = 0, high = (long) K * 5;
        while (low <= high) {
            long mid = (high - low) / 2 + low;
            long endZeroes = endZeroes(mid);
            if (endZeroes == K)
                return 5;
            else if (endZeroes > K)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return 0;
    }

    public long endZeroes(long num) {
        long zeroes = 0;
        while (num > 0) {
            num /= 5;
            zeroes += num;
        }
        return zeroes;
    }
}
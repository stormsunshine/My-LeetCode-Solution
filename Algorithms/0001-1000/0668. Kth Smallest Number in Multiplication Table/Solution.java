class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            int rank = rank(mid, m, n);
            if (rank < k)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public int rank(int num, int m, int n) {
        int rank = 0;
        int maxRow = Math.min(num, m);
        for (int i = 1; i <= maxRow; i++)
            rank += Math.min(num / i, n);
        return rank;
    }
}
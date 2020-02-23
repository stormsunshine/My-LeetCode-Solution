class Solution {
    public int countOrders(int n) {
        final int MODULO = 1000000007;
        long count = 1;
        for (int i = 2; i <= n; i++) {
            long twice = i * 2 % MODULO;
            long curCount = twice * (twice - 1) / 2 % MODULO;
            count = (count * curCount) % MODULO;
        }
        return (int) count;
    }
}
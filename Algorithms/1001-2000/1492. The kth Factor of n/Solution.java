class Solution {
    public int kthFactor(int n, int k) {
        if (k == 1)
            return 1;
        int sqrt = (int) Math.sqrt(n);
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0)
                factors.add(i);
        }
        int size = factors.size();
        int factorsCount = sqrt * sqrt == n ? size * 2 - 1 : size * 2;
        if (k > factorsCount)
            return -1;
        else if (k <= size)
            return factors.get(k - 1);
        else {
            int index = factorsCount - k;
            return n / factors.get(index);
        }
    }
}
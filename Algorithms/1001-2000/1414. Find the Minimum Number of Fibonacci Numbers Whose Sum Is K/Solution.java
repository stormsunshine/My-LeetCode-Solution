class Solution {
    public int findMinFibonacciNumbers(int k) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(0);
        set.add(1);
        int prev2 = 1, prev1 = 1;
        int num = 2;
        while (num <= k) {
            set.add(num);
            prev2 = prev1;
            prev1 = num;
            num = prev2 + prev1;
        }
        int count = 0;
        while (k > 0) {
            int fibo = set.floor(k);
            k -= fibo;
            count++;
        }
        return count;
    }
}
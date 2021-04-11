class Solution {
    public int findTheWinner(int n, int k) {
        int last = 0;
        for (int i = 2; i <= n; i++)
            last = (last + k) % i;
        last = last % n + 1;
        return last;
    }
}
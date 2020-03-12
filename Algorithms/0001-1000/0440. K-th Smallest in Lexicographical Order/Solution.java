class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        while (k > 0) {
            int steps = getSteps(n, curr, curr + 1);
            if (steps > k) {
                curr *= 10;
                k--;
            } else {
                curr++;
                k -= steps;
            }
        }
        return curr;
    }

    public int getSteps(int n, long curr, long next) {
        int steps = 0;
        while (curr <= n) {
            steps += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return steps;
    }
}
class Solution {
    public boolean judgeSquareSum(int c) {
        int low = 0, high = (int) Math.sqrt(c);
        while (low <= high) {
            int sum = low * low + high * high;
            if (sum == c)
                return true;
            else if (sum > c)
                high--;
            else
                low++;
        }
        return false;
    }
}
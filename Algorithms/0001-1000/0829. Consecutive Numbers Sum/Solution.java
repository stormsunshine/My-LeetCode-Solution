class Solution {
    public int consecutiveNumbersSum(int N) {
        int max = (int) Math.sqrt(N * 2);
        int count = 0;
        for (int i = 1; i <= max; i++) {
            if (i % 2 == 1) {
                if (N % i == 0)
                    count++;
            } else {
                if (N % i != 0 && N * 2 % i == 0)
                    count++;
            }
        }
        return count;
    }
}
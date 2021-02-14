class Solution {
    public int countHomogenous(String s) {
        final int MODULO = 1000000007;
        long totalCount = 0;
        int length = s.length();
        char prev = '0';
        int consecutive = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == prev)
                consecutive++;
            else {
                long curCount = (long) consecutive * (consecutive + 1) / 2 % MODULO;
                totalCount = (totalCount + curCount) % MODULO;
                consecutive = 1;
                prev = c;
            }
        }
        long curCount = (long) consecutive * (consecutive + 1) / 2 % MODULO;
        totalCount = (totalCount + curCount) % MODULO;
        return (int) totalCount;
    }
}
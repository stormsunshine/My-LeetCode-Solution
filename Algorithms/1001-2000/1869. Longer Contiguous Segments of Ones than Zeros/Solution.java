class Solution {
    public boolean checkZeroOnes(String s) {
        int length = s.length();
        int maxZeros = 0, maxOnes = 0;
        int zeros = 0, ones = 0;
        char prev = '2';
        for (int i = 0; i < length; i++) {
            char curr = s.charAt(i);
            if (curr == '0') {
                if (curr == prev) {
                    zeros++;
                    maxZeros = Math.max(maxZeros, zeros);
                } else {
                    zeros = 1;
                    maxZeros = Math.max(maxZeros, zeros);
                }
            } else {
                if (curr == prev) {
                    ones++;
                    maxOnes = Math.max(maxOnes, ones);
                } else {
                    ones = 1;
                    maxOnes = Math.max(maxOnes, ones);
                }
            }
            prev = curr;
        }
        return maxOnes > maxZeros;
    }
}
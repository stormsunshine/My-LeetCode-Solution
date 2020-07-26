class Solution {
    public int minFlips(String target) {
        int flips = 0;
        char prev = '0';
        int length = target.length();
        for (int i = 0; i < length; i++) {
            char curr = target.charAt(i);
            if (curr != prev)
                flips++;
            prev = curr;
        }
        return flips;
    }
}
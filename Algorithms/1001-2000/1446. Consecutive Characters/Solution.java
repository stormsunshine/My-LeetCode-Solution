class Solution {
    public int maxPower(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int length = s.length();
        int maxPower = 1;
        int power = 0;
        char prevC = 'A';
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == prevC) {
                power++;
                maxPower = Math.max(maxPower, power);
            } else {
                power = 1;
                prevC = c;
            }
        }
        return maxPower;
    }
}
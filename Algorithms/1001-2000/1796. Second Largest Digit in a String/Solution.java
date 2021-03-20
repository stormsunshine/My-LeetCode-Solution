class Solution {
    public int secondHighest(String s) {
        int[] counts = new int[10];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9')
                counts[c - '0']++;
        }
        boolean flag = false;
        for (int i = 9; i >= 0; i--) {
            if (counts[i] > 0) {
                if (!flag)
                    flag = true;
                else
                    return i;
            }
        }
        return -1;
    }
}
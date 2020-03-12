class Solution {
    public String sortString(String s) {
        int[] counts = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            counts[c - 'a']++;
        }
        StringBuffer sb = new StringBuffer();
        int remaining = length;
        boolean increasing = true;
        while (remaining > 0) {
            if (increasing) {
                for (int i = 0; i < 26; i++) {
                    if (counts[i] > 0) {
                        char c = (char) ('a' + i);
                        sb.append(c);
                        counts[i]--;
                        remaining--;
                    }
                }
            } else {
                for (int i = 25; i >= 0; i--) {
                    if (counts[i] > 0) {
                        char c = (char) ('a' + i);
                        sb.append(c);
                        counts[i]--;
                        remaining--;
                    }
                }
            }
            increasing = !increasing;
        }
        return sb.toString();
    }
}
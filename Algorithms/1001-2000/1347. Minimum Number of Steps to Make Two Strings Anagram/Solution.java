class Solution {
    public int minSteps(String s, String t) {
        int length = s.length();
        int[] counts = new int[26];
        for (int i = 0; i < length; i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            counts[c1 - 'a']++;
            counts[c2 - 'a']--;
        }
        int steps = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0)
                steps += counts[i];
        }
        return steps;
    }
}
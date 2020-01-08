class Solution {
    public int longestPalindrome(String s) {
        char[] array = s.toCharArray();
        int[] upperCounts = new int[26];
        int[] lowerCounts = new int[26];
        for (char c : array) {
            if (c <= 'Z')
                upperCounts[c - 'A']++;
            else
                lowerCounts[c - 'a']++;
        }
        boolean oddFlag = false;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            int upperCount = upperCounts[i], lowerCount = lowerCounts[i];
            count += upperCount / 2 * 2;
            count += lowerCount / 2 * 2;
            if (upperCount % 2 != 0 || lowerCount % 2 != 0)
                oddFlag = true;
        }
        if (oddFlag)
            count++;
        return count;
    }
}
class Solution {
    public boolean canConstruct(String s, int k) {
        int length = s.length();
        if (length < k)
            return false;
        if (length == k)
            return true;
        int[] counts = new int[26];
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            counts[c - 'a']++;
        }
        int oddCount = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] % 2 == 1)
                oddCount++;
        }
        return oddCount <= k;
    }
}
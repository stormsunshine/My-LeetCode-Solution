class Solution {
    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        int length = s.length();
        int halfLength = length / 2;
        int vowels1 = 0, vowels2 = 0;
        for (int i = 0; i < halfLength; i++) {
            char c1 = s.charAt(i), c2 = s.charAt(i + halfLength);
            if (isVowel(c1))
                vowels1++;
            if (isVowel(c2))
                vowels2++;
        }
        return vowels1 == vowels2;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
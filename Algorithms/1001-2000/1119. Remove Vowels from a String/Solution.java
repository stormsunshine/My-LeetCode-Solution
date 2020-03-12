class Solution {
    public String removeVowels(String S) {
        StringBuffer sb = new StringBuffer();
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (!isVowel(c))
                sb.append(c);
        }
        return sb.toString();
    }

    public boolean isVowel(char letter) {
        return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u';
    }
}
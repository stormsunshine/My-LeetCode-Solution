class Solution {
    public String makeGood(String s) {
        StringBuffer sb = new StringBuffer(s);
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (i == sb.length() - 1)
                continue;
            char c1 = sb.charAt(i), c2 = sb.charAt(i + 1);
            if (sameLetterDifferentCase(c1, c2)) {
                sb.deleteCharAt(i + 1);
                sb.deleteCharAt(i);
            }
        }
        return sb.toString();
    }

    public boolean sameLetterDifferentCase(char letter1, char letter2) {
        return Math.abs(letter1 - letter2) == 'a' - 'A';
    }
}
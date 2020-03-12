class Solution {
    public String shortestPalindrome(String s) {
        String reversed = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (s.substring(0, length - i).equals(reversed.substring(i))) {
                index = i;
                break;
            }
        }
        String palindrome = reversed.substring(0, index) + s;
        return palindrome;
    }
}
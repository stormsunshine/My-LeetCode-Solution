class Solution {
    public String breakPalindrome(String palindrome) {
        char[] array = palindrome.toCharArray();
        int length = array.length;
        if (length == 1)
            return "";
        int halfMax = length / 2;
        for (int i = 0; i < halfMax; i++) {
            char c = array[i];
            if (c != 'a') {
                array[i] = 'a';
                return new String(array);
            }
        }
        array[length - 1] = 'b';
        return new String(array);
    }
}
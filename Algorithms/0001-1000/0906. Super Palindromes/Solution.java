class Solution {
    public int superpalindromesInRange(String L, String R) {
        long squareLow = Long.parseLong(L), squareHigh = Long.parseLong(R);
        long low = (long) Math.ceil(Math.sqrt(squareLow));
        long high = (long) Math.floor(Math.sqrt(squareHigh));
        int count = 0;
        for (int i = 1; i < 100000; i++) {
            long palindrome = getOddLengthPalindrome(i);
            if (palindrome < low)
                continue;
            else if (palindrome > high)
                break;
            else {
                long square = palindrome * palindrome;
                if (isPalindrome(square))
                    count++;
            }
        }
        for (int i = 1; i < 100000; i++) {
            long palindrome = getEvenLengthPalindrome(i);
            if (palindrome < low)
                continue;
            else if (palindrome > high)
                break;
            else {
                long square = palindrome * palindrome;
                if (isPalindrome(square))
                    count++;
            }
        }
        return count;
    }

    public long getOddLengthPalindrome(int num) {
        StringBuffer sb = new StringBuffer(String.valueOf(num));
        int length = sb.length();
        for (int i = length - 2; i >= 0; i--)
            sb.append(sb.charAt(i));
        return Long.parseLong(sb.toString());
    }

    public long getEvenLengthPalindrome(int num) {
        StringBuffer sb = new StringBuffer(String.valueOf(num));
        int length = sb.length();
        for (int i = length - 1; i >= 0; i--)
            sb.append(sb.charAt(i));
        return Long.parseLong(sb.toString());
    }

    public boolean isPalindrome(long num) {
        char[] array = String.valueOf(num).toCharArray();
        int left = 0, right = array.length - 1;
        while (left < right) {
            if (array[left] != array[right])
                return false;
            left++;
            right--;
        }
        return true;
    }
}
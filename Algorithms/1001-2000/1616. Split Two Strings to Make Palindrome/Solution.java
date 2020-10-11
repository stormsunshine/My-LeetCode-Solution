class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        int length = a.length();
        if (isPalindrome(a, 0, length - 1) || isPalindrome(b, 0, length - 1))
            return true;
        if (a.charAt(0) == b.charAt(length - 1)) {
            if (checkPrefixSuffix(a, b))
                return true;
        }
        if (b.charAt(0) == a.charAt(length - 1)) {
            if (checkPrefixSuffix(b, a))
                return true;
        }
        return false;
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public boolean checkPrefixSuffix(String a, String b) {
        int left = 0, right = b.length() - 1;
        while (left < right) {
            if (a.charAt(left) == b.charAt(right)) {
                left++;
                right--;
            } else
                break;
        }
        return isPalindrome(a, left, right) || isPalindrome(b, left, right);
    }
}
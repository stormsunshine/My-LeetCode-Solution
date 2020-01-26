class Solution {
    public int removePalindromeSub(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int low = 0, high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else
                return 2;
        }
        return 1;
    }
}
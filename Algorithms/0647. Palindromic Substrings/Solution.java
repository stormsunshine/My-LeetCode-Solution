class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            count++;
            int maxLength = Math.min(i, length - 1 - i);
            for (int j = 1; j <= maxLength; j++) {
                if (s.charAt(i - j) == s.charAt(i + j))
                    count++;
                else
                    break;
            }
        }
        for (int i = 1; i < length; i++) {
            int left = i - 1, right = i;
            if (s.charAt(left) != s.charAt(right))
                continue;
            count++;
            int maxLength = Math.min(left, length - 1 - right);
            for (int j = 1; j <= maxLength; j++) {
                if (s.charAt(left - j) == s.charAt(right + j))
                    count++;
                else
                    break;
            }
        }
        return count;
    }
}
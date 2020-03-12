class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[128];
        char[] array = s.toCharArray();
        for (char c : array)
            count[c]++;
        boolean hasOdd = false;
        for (int i = 0; i < 128; i++) {
            int curCount = count[i];
            if (curCount % 2 != 0) {
                if (hasOdd)
                    return false;
                else
                    hasOdd = true;
            }
        }
        return true;
    }
}
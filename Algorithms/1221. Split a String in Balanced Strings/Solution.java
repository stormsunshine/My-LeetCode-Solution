class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
        int position = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == 'R')
                position++;
            else
                position--;
            if (position == 0)
                count++;
        }
        return count;
    }
}
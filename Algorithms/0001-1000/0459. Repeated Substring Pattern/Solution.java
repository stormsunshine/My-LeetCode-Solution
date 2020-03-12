class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() <= 1)
            return false;
        int length = s.length();
        StringBuffer subStringBuffer = new StringBuffer();
        int maxSublength = length / 2;
        for (int i = 0; i < maxSublength; i++) {
            subStringBuffer.append(s.charAt(i));
            int curLength = i + 1;
            if (length % curLength != 0)
                continue;
            int times = length / curLength;
            StringBuffer temp = new StringBuffer();
            for (int j = 0; j < times; j++)
                temp.append(subStringBuffer);
            if (temp.toString().equals(s))
                return true;
        }
        return false;
    }
}
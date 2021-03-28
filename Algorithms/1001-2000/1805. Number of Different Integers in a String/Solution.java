class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<String>();
        StringBuffer sb = new StringBuffer();
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            if (Character.isDigit(c))
                sb.append(c);
            else {
                if (sb.length() > 0) {
                    String num = removeLeadingZeroes(sb.toString());
                    set.add(num);
                    sb.setLength(0);
                }
            }
        }
        if (sb.length() > 0) {
            String num = removeLeadingZeroes(sb.toString());
            set.add(num);
        }
        return set.size();
    }

    public String removeLeadingZeroes(String str) {
        int length = str.length();
        if (length == 1)
            return str;
        int start = 0;
        while (start < length) {
            if (str.charAt(start) != '0')
                break;
            start++;
        }
        return str.substring(start);
    }
}
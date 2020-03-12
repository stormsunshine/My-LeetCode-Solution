class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1 == null || str2 == null)
            return null;
        while (str1.length() > 0 && str2.length() > 0) {
            if (str1.length() > str2.length()) {
                String temp = str1;
                str1 = str2;
                str2 = temp;
            }
            if (str2.indexOf(str1) < 0)
                return "";
            str2 = str2.substring(str1.length());
        }
        return str1.length() == 0 ? str2 : str1;
    }
}
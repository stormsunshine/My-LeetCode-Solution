class Solution {
    public String countAndSay(int n) {
        String str = "";
        for (int i = 1; i <= n; i++)
            str = next(str);
        return str;
    }

    public String next(String str) {
        if (str.length() == 0)
            return "1";
        String next = "";
        int length = str.length();
        char prevChar = str.charAt(0);
        int count = 1;
        for (int i = 1; i < length; i++) {
            char curChar = str.charAt(i);
            if (curChar == prevChar)
                count++;
            else {
                next += count;
                next += prevChar;
                count = 1;
            }
            prevChar = curChar;
        }
        if (count > 0) {
            next += count;
            next += prevChar;
        }
        return next;
    }
}
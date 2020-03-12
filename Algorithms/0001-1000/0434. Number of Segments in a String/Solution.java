class Solution {
    public int countSegments(String s) {
        if (s == null)
            return 0;
        s = s.trim();
        while (s.indexOf("  ") >= 0)
            s = s.replaceAll("  ", " ");
        int length = s.length();
        if (length == 0)
            return 0;
        int segments = 1;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ')
                segments++;
        }
        return segments;
    }
}
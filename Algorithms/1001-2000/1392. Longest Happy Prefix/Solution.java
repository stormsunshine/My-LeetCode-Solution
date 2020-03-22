class Solution {
    public String longestPrefix(String s) {
        if (s == null)
            return s;
        int length = s.length();
        if (length <= 1)
            return "";
        int[] prefix = prefix(s);
        return s.substring(0, prefix[length - 1] + 1);
    }

    public int[] prefix(String str) {
        int length = str.length();
        int[] prefix = new int[length];
        Arrays.fill(prefix, -1);
        int index = -1;
        for (int i = 1; i < length; i++) {
            while (index >= 0 && str.charAt(index + 1) != str.charAt(i))
                index = prefix[index];
            if (str.charAt(index + 1) == str.charAt(i))
                index++;
            prefix[i] = index;
        }
        return prefix;
    }
}
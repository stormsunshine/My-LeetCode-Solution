class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        int[] differences = new int[length];
        for (int i = 0; i < length; i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            differences[i] = Math.abs(c1 - c2);
        }
        int maxLength = 0;
        int start = 0, end = 0;
        int sum = differences[0];
        if (sum <= maxCost)
            maxLength = 1;
        while (end < length - 1) {
            sum += differences[++end];
            while (sum > maxCost)
                sum -= differences[start++];
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
class Solution {
    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0)
            return 0;
        int[] counts = new int[26];
        int length = p.length();
        counts[p.charAt(0) - 'a'] = 1;
        int prevCount = 1;
        for (int i = 1; i < length; i++) {
            char curC = p.charAt(i), prevC = p.charAt(i - 1);
            int curIndex = curC - 'a', prevIndex = prevC - 'a';
            int dif = (curIndex - prevIndex + 26) % 26;
            int curCount = dif == 1 ? prevCount + 1 : 1;
            counts[curIndex] = Math.max(counts[curIndex], curCount);
            prevCount = curCount;
        }
        int sum = 0;
        for (int count : counts)
            sum += count;
        return sum;
    }
}
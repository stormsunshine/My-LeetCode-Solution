class Solution {
    public boolean queryString(String S, int N) {
        Set<Integer> set = new HashSet<Integer>();
        int length = S.length();
        for (int i = 0; i < length; i++) {
            int curNum = 0;
            int end = Math.min(i + 31, length);
            for (int j = i; j < end; j++) {
                curNum = (curNum << 1) + (S.charAt(j) - '0');
                set.add(curNum);
            }
        }
        for (int i = 1; i <= N; i++) {
            if (!set.contains(i))
                return false;
        }
        return true;
    }
}
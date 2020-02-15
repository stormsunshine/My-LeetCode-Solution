class Solution {
    public int minAddToMakeValid(String S) {
        int addCount = 0;
        int curCount = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == '(')
                curCount++;
            else {
                if (curCount > 0)
                    curCount--;
                else
                    addCount++;
            }
        }
        addCount += curCount;
        return addCount;
    }
}
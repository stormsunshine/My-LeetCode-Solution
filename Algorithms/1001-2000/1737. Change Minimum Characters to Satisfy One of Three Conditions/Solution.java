class Solution {
    public int minCharacters(String a, String b) {
        int[] aCounts = new int[26];
        int[] bCounts = new int[26];
        int aMaxCount = 0, bMaxCount = 0;
        int aLength = a.length(), bLength = b.length();
        for (int i = 0; i < aLength; i++) {
            char c = a.charAt(i);
            aCounts[c - 'a']++;
            aMaxCount = Math.max(aMaxCount, aCounts[c - 'a']);
        }
        for (int i = 0; i < bLength; i++) {
            char c = b.charAt(i);
            bCounts[c - 'a']++;
            bMaxCount = Math.max(bMaxCount, bCounts[c - 'a']);
        }
        int[] aCountsPrefix = new int[26];
        int[] aCountsSuffix = new int[26];
        int[] bCountsPrefix = new int[26];
        int[] bCountsSuffix = new int[26];
        aCountsPrefix[0] = aCounts[0];
        bCountsPrefix[0] = bCounts[0];
        for (int i = 1; i < 26; i++) {
            aCountsPrefix[i] = aCountsPrefix[i - 1] + aCounts[i];
            bCountsPrefix[i] = bCountsPrefix[i - 1] + bCounts[i];
        }
        aCountsSuffix[25] = aCounts[25];
        bCountsSuffix[25] = bCounts[25];
        for (int i = 24; i >= 0; i--) {
            aCountsSuffix[i] = aCountsSuffix[i + 1] + aCounts[i];
            bCountsSuffix[i] = bCountsSuffix[i + 1] + bCounts[i];
        }
        int op1 = Integer.MAX_VALUE, op2 = Integer.MAX_VALUE;
        for (int i = 0; i < 25; i++) {
            int curOp1 = aLength - aCountsPrefix[i] + bLength - bCountsSuffix[i + 1];
            int curOp2 = aLength - aCountsSuffix[i + 1] + bLength - bCountsPrefix[i];
            op1 = Math.min(op1, curOp1);
            op2 = Math.min(op2, curOp2);
        }
        int op3 = aLength - aMaxCount + bLength - bMaxCount;
        return Math.min(Math.min(op1, op2), op3);
    }
}
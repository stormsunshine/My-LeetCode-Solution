class Solution {
    public int minOperations(String s) {
        int op1 = 0, op2 = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (i % 2 == 0) {
                if (c == '1')
                    op1++;
                else
                    op2++;
            } else {
                if (c == '1')
                    op2++;
                else
                    op1++;
            }
        }
        return Math.min(op1, op2);
    }
}
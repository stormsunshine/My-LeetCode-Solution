class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        while (m > 0 && n > 0) {
            int log1 = (int) (Math.log(m) / Math.log(2));
            int log2 = (int) (Math.log(n) / Math.log(2));
            if (log1 != log2)
                return res;
            int curAndVal = 1 << log1;
            res += curAndVal;
            m -= curAndVal;
            n -= curAndVal;
        }
        return res;
    }
}
class Solution {
    public boolean hasAlternatingBits(int n) {
        if (n <= 2)
            return true;
        else if (n <= 4)
            return false;
        int prevBit = n & 1;
        n >>= 1;
        while (n > 0) {
            int curBit = n & 1;
            if (prevBit == curBit)
                return false;
            prevBit = curBit;
            n >>= 1;
        }
        return true;
    }
}
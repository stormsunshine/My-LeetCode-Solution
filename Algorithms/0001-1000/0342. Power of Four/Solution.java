class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0)
            return false;
        int remain = num;
        while (remain > 1) {
            if (remain % 4 != 0)
                return false;
            remain /= 4;
        }
        return true;
    }
}
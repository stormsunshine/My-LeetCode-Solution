class Solution {
    public boolean isUgly(int num) {
        if (num == 0)
            return false;
        int temp = num;
        int[] factors = {2, 3, 5};
        int length = factors.length;
        for (int i = 0; i < length; i++) {
            int factor = factors[i];
            while (temp % factor == 0)
                temp /= factor;
        }
        return temp == 1;
    }
}
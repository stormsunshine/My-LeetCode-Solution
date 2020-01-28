class Solution {
    public int superPow(int a, int[] b) {
        final int MODULO = 1337;
        a %= MODULO;
        if (a == 1)
            return 1;
        int length = b.length;
        int pow = 1;
        for (int i = 0; i < length; i++) {
            int prevPow = pow;
            if (prevPow > 1) {
                int prevPow2 = prevPow * prevPow % MODULO;
                int prevPow4 = prevPow2 * prevPow2 % MODULO;
                int prevPow8 = prevPow4 * prevPow4 % MODULO;
                pow = pow * prevPow % MODULO * prevPow8 % MODULO;
            }
            int exponent = b[i];
            for (int j = 0; j < exponent; j++)
                pow = pow * a % MODULO;
        }
        return pow;
    }
}
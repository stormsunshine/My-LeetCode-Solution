class Solution {
    public int findIntegers(int num) {
        if (num <= 2)
            return num + 1;
        int bits = (int) (Math.log(num) / Math.log(2));
        int counts = 2;
        int zeros = 0, ones = 1;
        for (int i = 2; i <= bits; i++) {
            int newZeros = zeros + ones;
            ones = zeros;
            zeros = newZeros;
            counts += zeros;
            counts += ones;
        }
        int zerosUnrestricted = 0, zerosRestricted = 0, onesUnrestricted = 0, onesRestricted = 1;
        for (int i = 1; i <= bits; i++) {
            int curBit = (num >> bits - i) & 1;
            if (curBit == 0) {
                int curZerosUnrestricted = zerosUnrestricted + onesUnrestricted;
                int curZerosRestricted = zerosRestricted + onesRestricted;
                int curOnesUnrestricted = zerosUnrestricted;
                int curOnesRestricted = 0;
                zerosUnrestricted = curZerosUnrestricted;
                zerosRestricted = curZerosRestricted;
                onesUnrestricted = curOnesUnrestricted;
                onesRestricted = curOnesRestricted;
            } else {
                int curZerosUnrestricted = zerosUnrestricted + zerosRestricted + onesUnrestricted + onesRestricted;
                int curZerosRestricted = 0;
                int curOnesUnrestricted = zerosUnrestricted;
                int curOnesRestricted = zerosRestricted;
                zerosUnrestricted = curZerosUnrestricted;
                zerosRestricted = curZerosRestricted;
                onesUnrestricted = curOnesUnrestricted;
                onesRestricted = curOnesRestricted;
            }
        }
        counts += zerosUnrestricted + zerosRestricted + onesUnrestricted + onesRestricted;
        return counts;
    }
}
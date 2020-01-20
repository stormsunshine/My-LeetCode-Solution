class Solution {
    public boolean reorderedPowerOf2(int N) {
        if (N == 1000000000)
            return false;
        if (N < 10)
            return N == 1 || N == 2 || N == 4 || N == 8;
        int length = String.valueOf(N).length();
        int lower = (int) Math.pow(10, length - 1);
        int upper = lower * 10;
        int log = (int) (Math.log(lower) / Math.log(2));
        int power2 = (int) Math.pow(2, log);
        while (power2 < lower)
            power2 *= 2;
        int[] numCount = new int[10];
        char[] array = String.valueOf(N).toCharArray();
        for (char c : array)
            numCount[c - '0']++;
        while (power2 < upper) {
            if (check(power2, numCount))
                return true;
            power2 *= 2;
        }
        return false;
    }

    public boolean check(int power2, int[] numCount) {
        int[] count = new int[10];
        char[] array = String.valueOf(power2).toCharArray();
        for (char c : array)
            count[c - '0']++;
        for (int i = 0; i <= 9; i++) {
            if (count[i] != numCount[i])
                return false;
        }
        return true;
    }
}
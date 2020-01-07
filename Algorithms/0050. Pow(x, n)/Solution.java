class Solution {
    public double myPow(double x, int n) {
        if (x == 0.0)
            return 0.0;
        if (n == 0)
            return 1.0;
        if (n == 1)
            return x;
        if (n == -1)
            return 1 / x;
        if (n == Integer.MIN_VALUE) {
            double power = 1 / x;
            for (int i = 1; i <= 31; i++)
                power = Math.pow(power, 2);
            return power;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        int length = (int) (Math.log(n) / Math.log(2)) + 1;
        double[] powers = new double[length];
        powers[0] = x;
        for (int i = 1; i < length; i++)
            powers[i] = Math.pow(powers[i - 1], 2);
        double power = 1;
        for (int i = length - 1; i >= 0; i--) {
            int index = (int) Math.pow(2, i);
            if (n < index)
                continue;
            power *= powers[i];
            n -= index;
            if (n == 0)
                break;
        }
        return power;
    }
}
class Solution {
    public boolean isRationalEqual(String S, String T) {
        int[] rationalS = getRational(S);
        int[] rationalT = getRational(T);
        return rationalS[0] == rationalT[0] && rationalS[1] == rationalT[1];
    }

    public int[] getRational(String str) {
        boolean positive = true;
        if (str.charAt(0) == '-') {
            str = str.substring(1);
            positive = false;
        }
        int dotIndex = str.indexOf('.');
        if (dotIndex < 0) {
            int integer = Integer.parseInt(str);
            if (!positive)
                integer = -integer;
            int[] rational = {integer, 1};
            return rational;
        }
        int length = str.length();
        if (dotIndex == length - 1) {
            int integer = Integer.parseInt(str.substring(0, dotIndex));
            if (!positive)
                integer = -integer;
            int[] rational = {integer, 1};
            return rational;
        }
        String integerPart = str.substring(0, dotIndex);
        int integer = Integer.parseInt(integerPart);
        String decimalPart = str.substring(dotIndex + 1);
        int decimalPartLength = length - dotIndex - 1;
        int repeatingIndex = str.indexOf('(');
        if (repeatingIndex < 0) {
            int numerator = Integer.parseInt(decimalPart);
            int denominator = (int) Math.pow(10, decimalPartLength);
            int gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
            int[] rational = {numerator, denominator};
            rational[0] += integer * denominator;
            if (!positive)
                rational[0] = -rational[0];
            return rational;
        } else {
            if (repeatingIndex - dotIndex == 1) {
                int numerator = Integer.parseInt(str.substring(repeatingIndex + 1, length - 1));
                int denominator = (int) Math.pow(10, decimalPartLength - 2) - 1;
                int gcd = gcd(numerator, denominator);
                numerator /= gcd;
                denominator /= gcd;
                int[] rational = {numerator, denominator};
                rational[0] += integer * denominator;
                if (!positive)
                    rational[0] = -rational[0];
                return rational;
            } else {
                int nonRepeatingLength = repeatingIndex - dotIndex - 1;
                int repeatingLength = length - 2 - repeatingIndex;
                int nonRepeating = Integer.parseInt(str.substring(dotIndex + 1, repeatingIndex));
                int numerator = nonRepeating * (int) Math.pow(10, repeatingLength) + Integer.parseInt(str.substring(repeatingIndex + 1, length - 1)) - nonRepeating;
                int denominator = (int) (Math.pow(10, repeatingLength) - 1) * (int) (Math.pow(10, nonRepeatingLength));
                int gcd = gcd(numerator, denominator);
                numerator /= gcd;
                denominator /= gcd;
                int[] rational = {numerator, denominator};
                rational[0] += integer * denominator;
                if (!positive)
                    rational[0] = -rational[0];
                return rational;
            }
        }
    }

    public int gcd(int a, int b) {
        if (a == 0 && b == 0)
            return 1;
        while (a > 0 && b > 0) {
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            b %= a;
        }
        return a == 0 ? b : a;
    }
}
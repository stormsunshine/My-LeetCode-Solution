class Solution {
    public int[] closestDivisors(int num) {
        long num1 = num + 1, num2 = num + 2;
        long sqrt1 = (long) Math.sqrt(num1);
        long factor1 = 2;
        long factor1Max = 1;
        long sqrt2 = (long) Math.sqrt(num2);
        long factor3 = 2;
        long factor3Max = 1;
        while (factor1 <= sqrt1) {
            if (num1 % factor1 == 0)
                factor1Max = factor1;
            factor1++;
        }
        while (factor3 <= sqrt2) {
            if (num2 % factor3 == 0)
                factor3Max = factor3;
            factor3++;
        }
        factor1 = factor1Max;
        factor3 = factor3Max;
        long factor2 = num1 / factor1;
        long factor4 = num2 / factor3;
        if (Math.abs(factor2 - factor1) <= Math.abs(factor4 - factor3))
            return new int[]{(int) factor1, (int) factor2};
        else
            return new int[]{(int) factor3, (int) factor4};
    }
}
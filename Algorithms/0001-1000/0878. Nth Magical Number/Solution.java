class Solution {
    public int nthMagicalNumber(int N, int A, int B) {
        final int MODULO = 1000000007;
        if (A > B) {
            int temp = A;
            A = B;
            B = temp;
        }
        if (B % A == 0) {
            long num = (long) A * (long) N;
            return (int) (num % MODULO);
        } else {
            int lcm = lcm(A, B);
            int count = lcm / A + lcm / B - 1;
            int groups = N / count;
            long num = (long) lcm * (long) groups;
            int remainder = N % count;
            if (remainder == 0)
                return (int) (num % MODULO);
            else {
                int magicalNum = 1;
                int num1 = A, num2 = B;
                for (int i = 1; i <= remainder; i++) {
                    if (num1 < num2) {
                        magicalNum = num1;
                        num1 += A;
                    } else {
                        magicalNum = num2;
                        num2 += B;
                    }
                }
                num %= MODULO;
                num += magicalNum;
                return (int) (num % MODULO);
            }
        }
    }

    public int lcm(int num1, int num2) {
        return num1 * num2 / gcd(num1, num2);
    }

    public int gcd(int num1, int num2) {
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);
        if (num1 == 0 && num2 == 0)
            return 1;
        while (num1 != 0 && num2 != 0) {
            if (num1 > num2) {
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }
            num2 %= num1;
        }
        return num1 == 0 ? num2 : num1;
    }
}
class Solution {
    public boolean splitArraySameAverage(int[] A) {
        if (A == null || A.length < 2)
            return false;
        Arrays.sort(A);
        int length = A.length;
        if (A[length - 1] == 0)
            return true;
        int gcd = A[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            if (A[i] == 0)
                break;
            gcd = gcd(gcd, A[i]);
        }
        for (int i = length - 1; i >= 0; i--) {
            if (A[i] == 0)
                break;
            A[i] /= gcd;
        }
        int sum = 0;
        for (int num : A)
            sum += num;
        if (gcd(sum, length) == 1)
            return false;
        if (A[length - 2] * (length - 1) < sum - A[length - 2])
            return false;
        int power = 1 << length;
        for (int i = 1; i < power - 1; i++) {
            int curCount = 0;
            int curSum = 0;
            for (int j = length - 1; j >= 0; j--) {
                if ((i >> j & 1) != 0) {
                    curCount++;
                    curSum += A[j];
                }
            }
            if (sum * curCount == curSum * length)
                return true;
        }
        return false;
    }

    public int gcd(int num1, int num2) {
        if (num1 == 0 && num2 == 0)
            return 1;
        else if (num1 == 0)
            return num2;
        else if (num2 == 0)
            return num1;
        else {
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
}
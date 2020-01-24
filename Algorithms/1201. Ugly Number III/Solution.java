class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long lcmAB = a / gcd(a, b) * b;
        long lcmBC = b / gcd(b, c) * c;
        long lcmAC = a / gcd(a, c) * c;
        long lcmABC = lcmAB / gcd(lcmAB, c) * c;
        long low = 1, high = 2000000000;
        while (low < high) {
            long mid = (high - low) / 2 + low;
            long count = mid / a + mid / b + mid / c - mid / lcmAB - mid / lcmBC - mid / lcmAC + mid / lcmABC;
            if (count < n)
                low = mid + 1;
            else
                high = mid;
        }
        return (int) low;
    }

    public long gcd(long a, long b) {
        if (a == 0 && b == 0)
            return 1;
        while (a != 0 && b != 0) {
            if (a > b) {
                long temp = a;
                a = b;
                b = temp;
            }
            b %= a;
        }
        return a == 0 ? b : a;
    }
}
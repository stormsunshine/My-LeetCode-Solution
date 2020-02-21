class Solution {
    public int mirrorReflection(int p, int q) {
        int firstMeet = p * q / gcd(p, q);
        int reflectTimes = firstMeet / q;
        if (reflectTimes % 2 == 0)
            return 2;
        else {
            int squares = firstMeet / p;
            return squares % 2 == 0 ? 0 : 1;
        }
    }

    public int gcd(int p, int q) {
        if (p == 0 && q == 0)
            return 1;
        while (p > 0 && q > 0) {
            if (p > q) {
                int temp = p;
                p = q;
                q = temp;
            }
            q %= p;
        }
        return p == 0 ? q : p;
    }
}
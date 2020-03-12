class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z)
            return false;
        int gcd = gcd(x, y);
        return z % gcd == 0;
    }

    public int gcd(int x, int y) {
        if (x == 0 && y == 0)
            return 1;
        while (x != 0 && y != 0) {
            if (x > y) {
                int temp = x;
                x = y;
                y = temp;
            }
            y %= x;
        }
        return x == 0 ? y : x;
    }
}
class Solution {
    public int hammingDistance(int x, int y) {
        if (x == y)
            return 0;
        int distance = 0;
        while (x > 0 || y > 0) {
            int xBit = x & 0x1, yBit = y & 0x1;
            if (xBit != yBit)
                distance++;
            x >>>= 1;
            y >>>= 1;
        }
        return distance;
    }
}
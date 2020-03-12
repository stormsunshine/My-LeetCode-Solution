class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (p1[0] == p2[0] && p1[1] == p2[1])
            return false;
        if (p1[0] == p3[0] && p1[1] == p3[1])
            return false;
        if (p1[0] == p4[0] && p1[1] == p4[1])
            return false;
        if (p2[0] == p3[0] && p2[1] == p3[1])
            return false;
        if (p2[0] == p4[0] && p2[1] == p4[1])
            return false;
        if (p3[0] == p4[0] && p3[1] == p4[1])
            return false;
        int[] distanceSquares = new int[6];
        distanceSquares[0] = distanceSquare(p1, p2);
        distanceSquares[1] = distanceSquare(p1, p3);
        distanceSquares[2] = distanceSquare(p1, p4);
        distanceSquares[3] = distanceSquare(p2, p3);
        distanceSquares[4] = distanceSquare(p2, p4);
        distanceSquares[5] = distanceSquare(p3, p4);
        Arrays.sort(distanceSquares);
        if (distanceSquares[0] != distanceSquares[1] || distanceSquares[1] != distanceSquares[2] || distanceSquares[2] != distanceSquares[3])
            return false;
        else if (distanceSquares[4] != distanceSquares[5])
            return false;
        else
            return true;
    }

    public int distanceSquare(int[] p1, int[] p2) {
        return (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
    }
}
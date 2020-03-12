class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long area1 = ((long) C - (long) A) * ((long) D - (long) B), area2 = ((long) G - (long) E) * ((long) H - (long) F);
        long overlapWidth = (long) Math.min(C, G) - (long) Math.max(A, E), overlapHeight = (long) Math.min(D, H) - (long) Math.max(B, F);
        long overlapArea = Math.max(overlapWidth, 0) * Math.max(overlapHeight, 0);
        return (int) (area1 + area2 - overlapArea);
    }
}
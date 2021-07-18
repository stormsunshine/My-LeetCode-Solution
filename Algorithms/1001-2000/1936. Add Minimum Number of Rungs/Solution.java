class Solution {
    public int addRungs(int[] rungs, int dist) {
        int addCount = 0;
        int prev = 0;
        int length = rungs.length;
        for (int i = 0; i < length; i++) {
            int curr = rungs[i];
            int difference = curr - prev;
            addCount += (difference - 1) / dist;
            prev = curr;
        }
        return addCount;
    }
}
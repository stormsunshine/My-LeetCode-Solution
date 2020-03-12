class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        if (target == 0)
            return 0;
        int position = 0;
        int step = 0;
        while (position < target || position % 2 != target % 2) {
            step++;
            position += step;
        }
        return step;
    }
}
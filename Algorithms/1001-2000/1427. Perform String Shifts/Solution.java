class Solution {
    public String stringShift(String s, int[][] shift) {
        int totalShift = 0;
        for (int[] curShift : shift) {
            int direction = curShift[0], amount = curShift[1];
            if (direction == 1)
                amount = -amount;
            totalShift += amount;
        }
        int length = s.length();
        totalShift %= length;
        if (totalShift < 0)
            totalShift += length;
        String shifted = s.substring(totalShift) + s.substring(0, totalShift);
        return shifted;
    }
}
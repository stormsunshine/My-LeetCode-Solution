class Solution {
    public int numberOfPatterns(int m, int n) {
        int patterns = 0;
        for (int i = m; i <= n; i++)
            patterns += numberOfPatterns(i);
        return patterns;
    }

    public int numberOfPatterns(int keys) {
        return backtrack(keys, 0, 0);
    }

    public int backtrack(int keys, int state, int prevKey) {
        if (keys == 0)
            return 1;
        int patterns = 0;
        if (prevKey == 0) {
            for (int i = 1; i <= 9; i++) {
                if (((state >> i) & 1) == 0) {
                    int newState = state | (1 << i);
                    patterns += backtrack(keys - 1, newState, i);
                }
            }
        } else {
            for (int i = 1; i <= 9; i++) {
                if (((state >> i) & 1) == 0 && isLegal(state, i, prevKey)) {
                    int newState = state | (1 << i);
                    patterns += backtrack(keys - 1, newState, i);
                }
            }
        }
        return patterns;
    }

    public boolean isLegal(int state, int curKey, int prevKey) {
        if (curKey == prevKey)
            return false;
        if (((state >> prevKey) & 1) == 0 || ((state >> curKey) & 1) == 1)
            return false;
        if (curKey % 2 != prevKey % 2)
            return true;
        int avg = (curKey + prevKey) / 2;
        if ((avg == 5) && ((state >> avg) & 1) == 0)
            return false;
        if (avg % 2 == 0 && curKey % 2 != 0 && curKey != 5 && prevKey != 5 && ((state >> avg) & 1) == 0)
            return false;
        return true;
    }
}
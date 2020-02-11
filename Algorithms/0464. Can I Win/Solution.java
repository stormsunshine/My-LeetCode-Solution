class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int maxSum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (maxSum < desiredTotal)
            return false;
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        return depthFirstSearch(0, maxChoosableInteger, desiredTotal, map);
    }

    public boolean depthFirstSearch(int state, int maxChoosableInteger, int desiredTotal, Map<Integer, Boolean> map) {
        if (desiredTotal <= 0) {
            map.put(state, true);
            return true;
        }
        if (map.containsKey(state))
            return map.get(state);
        boolean flag = false;
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if (((state >> i) & 1) == 0) {
                if (i >= desiredTotal) {
                    map.put(state, true);
                    return true;
                } else {
                    int nextState = state | (1 << i);
                    flag = !depthFirstSearch(nextState, maxChoosableInteger, desiredTotal - i, map);
                }
                if (flag)
                    break;
            }
        }
        map.put(state, flag);
        return flag;
    }
}
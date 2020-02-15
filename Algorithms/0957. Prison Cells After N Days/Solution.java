class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> stateDayMap = new HashMap<String, Integer>();
        Map<Integer, int[]> dayStateMap = new HashMap<Integer, int[]>();
        int[] prevCells = new int[8];
        System.arraycopy(cells, 0, prevCells, 0, 8);
        int days = 0;
        int cycle = 0;
        while (days < N) {
            days++;
            int[] change = new int[8];
            change[0] = 0;
            change[7] = 0;
            for (int i = 1; i < 7; i++) {
                if (prevCells[i - 1] == prevCells[i + 1])
                    change[i] = 1;
            }
            for (int i = 0; i < 8; i++)
                prevCells[i] = change[i];
            String arrayStr = Arrays.toString(change);
            if (stateDayMap.containsKey(arrayStr)) {
                int prevDay = stateDayMap.get(arrayStr);
                cycle = days - prevDay;
                break;
            } else {
                stateDayMap.put(arrayStr, days);
                dayStateMap.put(days, change);
            }
        }
        if (days == N)
            return prevCells;
        int remainder = N % cycle;
        if (remainder == 0)
            remainder = cycle;
        return dayStateMap.get(remainder);
    }
}
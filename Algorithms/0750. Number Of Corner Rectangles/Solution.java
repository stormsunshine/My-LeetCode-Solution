class Solution {
    public int countCornerRectangles(int[][] grid) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int rows = grid.length, columns = grid[0].length;
        for (int i = 0; i < rows; i++) {
            List<Integer> onesColumns = new ArrayList<Integer>();
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1)
                    onesColumns.add(j);
            }
            if (onesColumns.size() > 1) {
                int size = onesColumns.size();
                for (int j = 0; j < size; j++) {
                    for (int k = j + 1; k < size; k++) {
                        int[] array = {onesColumns.get(j), onesColumns.get(k)};
                        String arrayStr = Arrays.toString(array);
                        int count = map.getOrDefault(arrayStr, 0);
                        count++;
                        map.put(arrayStr, count);
                    }
                }
            }
        }
        int totalCount = 0;
        Set<String> set = map.keySet();
        for (String key : set) {
            int count = map.getOrDefault(key, 0);
            totalCount += count * (count - 1) / 2;
        }
        return totalCount;
    }
}
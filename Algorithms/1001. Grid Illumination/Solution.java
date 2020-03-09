class Solution {
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        Set<Long> set = new HashSet<Long>();
        Map<Integer, Integer> rowMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> columnMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> diagonal1Map = new HashMap<Integer, Integer>();
        Map<Integer, Integer> diagonal2Map = new HashMap<Integer, Integer>();
        for (int[] lamp : lamps) {
            int row = lamp[0], column = lamp[1];
            long position = (long) row * (long) N + (long) column;
            set.add(position);
            int rowCount = rowMap.getOrDefault(row, 0) + 1;
            rowMap.put(row, rowCount);
            int columnCount = columnMap.getOrDefault(column, 0) + 1;
            columnMap.put(column, columnCount);
            int diagonal1 = row - column;
            int diagonal1Count = diagonal1Map.getOrDefault(diagonal1, 0) + 1;
            diagonal1Map.put(diagonal1, diagonal1Count);
            int diagonal2 = row + column;
            int diagonal2Count = diagonal2Map.getOrDefault(diagonal2, 0) + 1;
            diagonal2Map.put(diagonal2, diagonal2Count);
        }
        int[][] directions = {{0, 0}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        int queriesLength = queries.length;
        int[] queriesResult = new int[queriesLength];
        for (int i = 0; i < queriesLength; i++) {
            int[] query = queries[i];
            int queryRow = query[0], queryColumn = query[1];
            boolean flag = false;
            if (rowMap.containsKey(queryRow) || columnMap.containsKey(queryColumn))
                flag = true;
            else {
                int diagonal1 = queryRow - queryColumn, diagonal2 = queryRow + queryColumn;
                if (diagonal1Map.containsKey(diagonal1) || diagonal2Map.containsKey(diagonal2))
                    flag = true;
            }
            if (flag) {
                queriesResult[i] = 1;
                for (int[] direction : directions) {
                    int row = queryRow + direction[0], column = queryColumn + direction[1];
                    int newDiagonal1 = row - column, newDiagonal2 = row + column;
                    if (row >= 0 && row < N && column >= 0 && column < N) {
                        long position = (long) row * (long) N + (long) column;
                        if (set.remove(position)) {
                            int rowCount = rowMap.get(row) - 1;
                            if (rowCount > 0)
                                rowMap.put(row, rowCount);
                            else
                                rowMap.remove(row);
                            int columnCount = columnMap.get(column) - 1;
                            if (columnCount > 0)
                                columnMap.put(column, columnCount);
                            else
                                columnMap.remove(column);
                            int diagonal1Count = diagonal1Map.get(newDiagonal1) - 1;
                            if (diagonal1Count > 0)
                                diagonal1Map.put(newDiagonal1, diagonal1Count);
                            else
                                diagonal1Map.remove(newDiagonal1);
                            int diagonal2Count = diagonal2Map.get(newDiagonal2) - 1;
                            if (diagonal2Count > 0)
                                diagonal2Map.put(newDiagonal2, diagonal2Count);
                            else
                                diagonal2Map.remove(newDiagonal2);
                        }
                    }
                }
            }
        }
        return queriesResult;
    }
}
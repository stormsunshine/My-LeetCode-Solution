class Excel {
    int rows;
    int columns;
    int[][] cells;
    Map<String, Map<String, Integer>> cellSumMap;
    Map<String, Map<String, Integer>> sumCellMap;

    public Excel(int H, char W) {
        rows = H + 1;
        columns = W - 'A' + 1;
        cells = new int[rows][columns];
        cellSumMap = new HashMap<String, Map<String, Integer>>();
        sumCellMap = new HashMap<String, Map<String, Integer>>();
    }
    
    public void set(int r, char c, int v) {
        int prevValue = cells[r][c - 'A'];
        int difference = v - prevValue;
        String cellName = String.valueOf(c) + r;
        Map<String, Integer> cellMap = sumCellMap.getOrDefault(cellName, new HashMap<String, Integer>());
        sumCellMap.remove(cellName);
        Set<String> cellSet = cellMap.keySet();
        for (String cell : cellSet) {
            Map<String, Integer> sumMap = cellSumMap.getOrDefault(cell, new HashMap<String, Integer>());
            sumMap.remove(cellName);
            cellSumMap.put(cell, sumMap);
        }
        updateRelevantCells(cellName, difference);
    }
    
    public int get(int r, char c) {
        return cells[r][c - 'A'];
    }
    
    public int sum(int r, char c, String[] strs) {
        int sum = 0;
        int prevValue = cells[r][c - 'A'];
        set(r, c, prevValue);
        String sumCellName = String.valueOf(c) + r;
        for (String str : strs) {
            if (str.indexOf(':') >= 0) {
                String[] array = str.split(":");
                String start = array[0], end = array[1];
                char startColumn = start.charAt(0), endColumn = end.charAt(0);
                int startRow = Integer.parseInt(start.substring(1)), endRow = Integer.parseInt(end.substring(1));
                for (int i = startRow; i <= endRow; i++) {
                    for (char j = startColumn; j <= endColumn; j++) {
                        String cellName = String.valueOf(j) + i;
                        Map<String, Integer> sumMap = cellSumMap.getOrDefault(cellName, new HashMap<String, Integer>());
                        int sumCount = sumMap.getOrDefault(sumCellName, 0) + 1;
                        sumMap.put(sumCellName, sumCount);
                        cellSumMap.put(cellName, sumMap);
                        Map<String, Integer> cellMap = sumCellMap.getOrDefault(sumCellName, new HashMap<String, Integer>());
                        int cellCount = cellMap.getOrDefault(cellName, 0) + 1;
                        cellMap.put(cellName, cellCount);
                        sumCellMap.put(sumCellName, cellMap);
                        sum += cells[i][j - 'A'];
                    }
                }
                
            } else {
                Map<String, Integer> sumMap = cellSumMap.getOrDefault(str, new HashMap<String, Integer>());
                int sumCount = sumMap.getOrDefault(sumCellName, 0) + 1;
                sumMap.put(sumCellName, sumCount);
                cellSumMap.put(str, sumMap);
                Map<String, Integer> cellMap = sumCellMap.getOrDefault(sumCellName, new HashMap<String, Integer>());
                int cellCount = cellMap.getOrDefault(str, 0) + 1;
                cellMap.put(str, cellCount);
                sumCellMap.put(sumCellName, cellMap);
                char cellColumn = str.charAt(0);
                int cellRow = Integer.parseInt(str.substring(1));
                sum += cells[cellRow][cellColumn - 'A'];
            }
        }
        int difference = sum - prevValue;
        updateRelevantCells(sumCellName, difference);
        return cells[r][c - 'A'];
    }

    private void updateRelevantCells(String cellName, int difference) {
        Queue<String> cellQueue = new LinkedList<String>();
        Queue<Integer> differenceQueue = new LinkedList<Integer>();
        cellQueue.offer(cellName);
        differenceQueue.offer(difference);
        while (!cellQueue.isEmpty()) {
            String cell = cellQueue.poll();
            int curDifference = differenceQueue.poll();
            char column = cell.charAt(0);
            int row = Integer.parseInt(cell.substring(1));
            cells[row][column - 'A'] += curDifference;
            Map<String, Integer> map = cellSumMap.getOrDefault(cell, new HashMap<String, Integer>());
            Set<String> set = map.keySet();
            for (String nextCell : set) {
                int count = map.get(nextCell);
                cellQueue.offer(nextCell);
                differenceQueue.offer(curDifference * count);
            }
        }
    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(H, W);
 * obj.set(r,c,v);
 * int param_2 = obj.get(r,c);
 * int param_3 = obj.sum(r,c,strs);
 */
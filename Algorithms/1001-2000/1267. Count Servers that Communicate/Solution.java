class Solution {
    public int countServers(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int servers = 0;
        int isolateServers = 0;
        Map<Integer, List<Integer>> rowsMap = new HashMap<Integer, List<Integer>>();
        Map<Integer, List<Integer>> columnsMap = new HashMap<Integer, List<Integer>>();
        int rows = grid.length, columns = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    servers++;
                    List<Integer> rowList = rowsMap.getOrDefault(i, new ArrayList<Integer>());
                    rowList.add(j);
                    rowsMap.put(i, rowList);
                    List<Integer> columnList = columnsMap.getOrDefault(j, new ArrayList<Integer>());
                    columnList.add(i);
                    columnsMap.put(j, columnList);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            List<Integer> rowList = rowsMap.getOrDefault(i, new ArrayList<Integer>());
            if (rowList.size() == 1) {
                int column = rowList.get(0);
                List<Integer> columnList = columnsMap.getOrDefault(column, new ArrayList<Integer>());
                if (columnList.size() == 1)
                    isolateServers++;
            }
        }
        int communicateServers = servers - isolateServers;
        return communicateServers;
    }
}
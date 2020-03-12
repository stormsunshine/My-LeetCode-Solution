class Solution {
    public int findLonelyPixel(char[][] picture) {
        if (picture == null || picture.length == 0 || picture[0].length == 0)
            return 0;
        Map<Integer, List<Integer>> rowMap = new HashMap<Integer, List<Integer>>();
        Map<Integer, List<Integer>> columnMap = new HashMap<Integer, List<Integer>>();
        int rows = picture.length, columns = picture[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (picture[i][j] == 'B') {
                    List<Integer> rowList = rowMap.getOrDefault(i, new ArrayList<Integer>());
                    List<Integer> columnList = columnMap.getOrDefault(j, new ArrayList<Integer>());
                    rowList.add(j);
                    columnList.add(i);
                    rowMap.put(i, rowList);
                    columnMap.put(j, columnList);
                }
            }
        }
        int lonelyPixels = 0;
        for (int i = 0; i < rows; i++) {
            List<Integer> rowList = rowMap.getOrDefault(i, new ArrayList<Integer>());
            if (rowList.size() == 1) {
                int column = rowList.get(0);
                List<Integer> columnList = columnMap.getOrDefault(column, new ArrayList<Integer>());
                if (columnList.size() == 1)
                    lonelyPixels++;
            }
        }
        return lonelyPixels;
    }
}
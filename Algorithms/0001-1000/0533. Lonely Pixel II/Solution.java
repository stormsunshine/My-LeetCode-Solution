class Solution {
    public int findBlackPixel(char[][] picture, int N) {
        if (picture == null || picture.length == 0 || picture[0].length == 0)
            return 0;
        Map<String, Integer> rowCountMap = new HashMap<String, Integer>();
        int rows = picture.length, columns = picture[0].length;
        for (int i = 0; i < rows; i++) {
            String row = new String(picture[i]);
            int count = rowCountMap.getOrDefault(row, 0);
            count++;
            rowCountMap.put(row, count);
        }
        int pixels = 0;
        Set<String> rowSet = rowCountMap.keySet();
        for (String rowStr : rowSet) {
            int count = rowCountMap.getOrDefault(rowStr, 0);
            if (count != N)
                continue;
            List<Integer> columnsList = new ArrayList<Integer>();
            for (int column = 0; column < columns; column++) {
                if (rowStr.charAt(column) == 'B')
                    columnsList.add(column);
            }
            if (columnsList.size() != N)
                continue;
            for (int column : columnsList) {
                int columnCount = 0;
                for (int row = 0; row < rows; row++) {
                    if (picture[row][column] == 'B')
                        columnCount++;
                }
                if (columnCount == N)
                    pixels += N;
            }
        }
        return pixels;
    }
}
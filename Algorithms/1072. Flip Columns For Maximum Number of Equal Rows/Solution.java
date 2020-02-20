class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patternCountMap = new HashMap<String, Integer>();
        for (int[] row : matrix) {
            int[] newArray = getRow(row);
            String rowStr = Arrays.toString(newArray);
            int count = patternCountMap.getOrDefault(rowStr, 0) + 1;
            patternCountMap.put(rowStr, count);
        }
        int maxCount = 0;
        Set<String> keySet = patternCountMap.keySet();
        for (String rowStr : keySet) {
            int count = patternCountMap.getOrDefault(rowStr, 0);
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public int[] getRow(int[] row) {
        int length = row.length;
        int[] newArray = new int[length];
        if (row[0] == 0) {
            for (int i = 0; i < length; i++)
                newArray[i] = row[i];
        } else {
            for (int i = 0; i < length; i++)
                newArray[i] = 1 - row[i];
        }
        return newArray;
    }
}
class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        int rows = destination[0], columns = destination[1];
        int length = rows + columns;
        int[][] combinations = getCombinations(length);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if (columns > 0) {
                int count = combinations[rows + columns - 1][columns - 1];
                if (k > count) {
                    k -= count;
                    sb.append('V');
                    rows--;
                } else {
                    sb.append('H');
                    columns--;
                }
            } else {
                sb.append('V');
                rows--;
            }
        }
        return sb.toString();
    }

    public int[][] getCombinations(int total) {
        int[][] combinations = new int[total + 1][total + 1];
        for (int i = 0; i <= total; i++)
            combinations[i][0] = 1;
        combinations[1][1] = 1;
        for (int i = 2; i <= total; i++) {
            for (int j = 1; j <= i; j++)
                combinations[i][j] = combinations[i - 1][j] + combinations[i - 1][j - 1];
        }
        return combinations;
    }
}
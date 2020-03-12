class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        final int SIDE = 8;
        Set<String> queensSet = new HashSet<String>();
        for (int[] queen : queens)
            queensSet.add(Arrays.toString(queen));
        int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        List<List<Integer>> queensAttackList = new ArrayList<List<Integer>>();
        for (int[] direction : directions) {
            int row = king[0] + direction[0], column = king[1] + direction[1];
            while (row >= 0 && row < SIDE && column >= 0 && column < SIDE) {
                int[] position = {row, column};
                if (queensSet.contains(Arrays.toString(position))) {
                    List<Integer> curQueen = new ArrayList<Integer>(Arrays.asList(row, column));
                    queensAttackList.add(curQueen);
                    break;
                } else {
                    row += direction[0];
                    column += direction[1];
                }
            }
        }
        return queensAttackList;
    }
}
class Solution {
    public int regionsBySlashes(String[] grid) {
        int length = grid.length;
        int[][][] regions = new int[length][length][4];
        int regionCount = 1;
        int remain = length * length * 4;
        Queue<int[]> queue = new LinkedList<int[]>();
        char topLeft = grid[0].charAt(0);
        if (topLeft == ' ') {
            for (int i = 0; i < 4; i++) {
                regions[0][0][i] = regionCount;
                remain--;
            }
            for (int i = 2; i < 4; i++)
                queue.offer(new int[]{0, 0, i});
        } else if (topLeft == '/') {
            for (int i = 0; i < 2; i++) {
                regions[0][0][i] = regionCount;
                remain--;
            }
            regionCount++;
            for (int i = 2; i < 4; i++) {
                regions[0][0][i] = regionCount;
                remain--;
                queue.offer(new int[]{0, 0, i});
            }
        } else {
            for (int i = 0; i < 4; i += 2) {
                regions[0][0][i] = regionCount;
                remain--;
                queue.offer(new int[]{0, 0, i});
            }
        }
        while (remain > 0) {
            while (!queue.isEmpty()) {
                int[] subcell = queue.poll();
                int row = subcell[0], column = subcell[1], subcellNum = subcell[2];
                char c = grid[row].charAt(column);
                if (c == ' ') {
                    for (int i = 0; i < 4; i++) {
                        if (regions[row][column][i] == 0) {
                            regions[row][column][i] = regionCount;
                            remain--;
                            queue.offer(new int[]{row, column, i});
                        }
                    }
                } else if (c == '/') {
                    int num1 = subcellNum % 2 == 0 ? subcellNum : subcellNum - 1;
                    int num2 = num1 + 1;
                    for (int i = num1; i <= num2; i++) {
                        if (regions[row][column][i] == 0) {
                            regions[row][column][i] = regionCount;
                            remain--;
                            queue.offer(new int[]{row, column, i});
                        }
                    }
                } else {
                    int num1 = subcellNum < 2 ? subcellNum : subcellNum - 2;
                    int num2 = num1 + 2;
                    for (int i = num1; i <= num2; i += 2) {
                        if (regions[row][column][i] == 0) {
                            regions[row][column][i] = regionCount;
                            remain--;
                            queue.offer(new int[]{row, column, i});
                        }
                    }
                }
                int[] adjacentSubcell = getAdjacentSubcell(row, column, subcellNum);
                int nextRow = adjacentSubcell[0], nextColumn = adjacentSubcell[1], nextSubcellNum = adjacentSubcell[2];
                if (nextRow >= 0 && nextRow < length && nextColumn >= 0 && nextColumn < length && regions[nextRow][nextColumn][nextSubcellNum] == 0) {
                    regions[nextRow][nextColumn][nextSubcellNum] = regionCount;
                    remain--;
                    queue.offer(adjacentSubcell);
                }
            }
            if (remain == 0)
                break;
            regionCount++;
            outer:
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (regions[i][j][k] == 0) {
                            regions[i][j][k] = regionCount;
                            remain--;
                            queue.offer(new int[]{i, j, k});
                            break outer;
                        }
                    }
                }
            }
        }
        return regionCount;
    }

    public int[] getAdjacentSubcell(int row, int column, int subcellNum) {
        int[] adjacentSubcell = {row, column, subcellNum};
        switch (subcellNum) {
            case 0:
                adjacentSubcell[0]--;
                break;
            case 1:
                adjacentSubcell[1]--;
                break;
            case 2:
                adjacentSubcell[1]++;
                break;
            case 3:
                adjacentSubcell[0]++;
                break;
            default:
        }
        adjacentSubcell[2] = 3 - adjacentSubcell[2];
        return adjacentSubcell;
    }
}
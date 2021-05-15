class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        moveToRight(box);
        char[][] rotated = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                rotated[j][m - 1 - i] = box[i][j];
        }
        return rotated;
    }

    public void moveToRight(char[][] box) {
        int m = box.length, n = box[0].length;
        for (int i = 0; i < m; i++) {
            int prevObstacle = n;
            int stones = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    int k = prevObstacle - 1;
                    while (k > j && stones > 0) {
                        box[i][k] = '#';
                        k--;
                        stones--;
                    }
                    while (k > j) {
                        box[i][k] = '.';
                        k--;
                    }
                    prevObstacle = j;
                } else if (box[i][j] == '#')
                    stones++;
            }
            if (stones > 0) {
                int k = prevObstacle - 1;
                while (k >= 0 && stones > 0) {
                    box[i][k] = '#';
                    k--;
                    stones--;
                }
                while (k >= 0) {
                    box[i][k] = '.';
                    k--;
                }
            }
        }
    }
}
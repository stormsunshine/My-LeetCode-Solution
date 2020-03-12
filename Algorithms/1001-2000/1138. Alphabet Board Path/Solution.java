class Solution {
    public String alphabetBoardPath(String target) {
        StringBuffer sequence = new StringBuffer();
        int length = target.length();
        int[][] positions = new int[length][2];
        for (int i = 0; i < length; i++) {
            int[] position = position(target.charAt(i));
            positions[i][0] = position[0];
            positions[i][1] = position[1];
        }
        if (target.charAt(0) != 'a') {
            int[] start = {0, 0};
            String path0 = path(start, positions[0]);
            sequence.append(path0);
        }
        sequence.append("!");
        for (int i = 1; i < length; i++) {
            int[] prevPosition = positions[i - 1];
            int[] curPosition = positions[i];
            String path = path(prevPosition, curPosition);
            sequence.append(path);
            sequence.append("!");
        }
        return sequence.toString();
    }

    public int[] position(char letter) {
        int number = letter - 'a';
        int row = number / 5;
        int column = number % 5;
        int[] position = {row, column};
        return position;
    }

    public String path(int[] position1, int[] position2) {
        int row1 = position1[0], column1 = position1[1], row2 = position2[0], column2 = position2[1];
        if (row1 == row2 && column1 == column2)
            return "";
        StringBuffer path = new StringBuffer();
        if (row1 == 5 && column1 == 0) {
            for (int i = row1; i > row2; i--)
                path.append("U");
            for (int i = column1; i < column2; i++)
                path.append("R");
        } else if (row2 == 5 && column2 == 0) {
            for (int i = column1; i > column2; i--)
                path.append("L");
            for (int i = row1; i < row2; i++)
                path.append("D");
        } else {
            for (int i = row1; i > row2; i--)
                path.append("U");
            for (int i = row1; i < row2; i++)
                path.append("D");
            for (int i = column1; i > column2; i--)
                path.append("L");
            for (int i = column1; i < column2; i++)
                path.append("R");
        }
        return path.toString();
    }
}
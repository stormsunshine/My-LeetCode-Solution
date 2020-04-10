class Solution {
    public int movesToChessboard(int[][] board) {
        int[] firstRow = board[0];
        if (!isBalanced(firstRow))
            return -1;
        int rows = board.length;
        int[] flags = new int[rows];
        flags[0] = 1;
        for (int i = 1; i < rows; i++) {
            if (same(board[i], firstRow))
                flags[i] = 1;
            else if (reverse(board[i], firstRow))
                flags[i] = 0;
            else
                return -1;
        }
        if (!isBalanced(flags))
            return -1;
        int rowSwapNum = getMinSwapNum(flags);
        int columnSwapNum = getMinSwapNum(firstRow);
        return rowSwapNum + columnSwapNum;
    }

    public boolean same(int[] array1, int[] array2) {
        int length = array1.length;
        for (int i = 0; i < length; i++) {
            if (array1[i] != array2[i])
                return false;
        }
        return true;
    }

    public boolean reverse(int[] array1, int[] array2) {
        int length = array1.length;
        for (int i = 0; i < length; i++) {
            if (array1[i] == array2[i])
                return false;
        }
        return true;
    }

    public boolean isBalanced(int[] array) {
        int count = 0;
        for (int num : array) {
            if (num == 1)
                count++;
            else
                count--;
        }
        return Math.abs(count) <= 1;
    }

    public int getMinSwapNum(int[] array) {
        int swapNum1 = 0, swapNum2 = 0;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                if (array[i] == 0)
                    swapNum1++;
                else
                    swapNum2++;
            } else {
                if (array[i] == 1)
                    swapNum1++;
                else
                    swapNum2++;
            }
        }
        if (swapNum1 % 2 == 0)
            swapNum1 /= 2;
        else
            swapNum1 = -1;
        if (swapNum2 % 2 == 0)
            swapNum2 /= 2;
        else
            swapNum2 = -1;
        if (swapNum1 == -1)
            return swapNum2;
        else if (swapNum2 == -1)
            return swapNum1;
        else
            return Math.min(swapNum1, swapNum2);
    }
}
class Solution {
    public int smallestCommonElement(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0)
            return -1;
        int rows = mat.length, columns = mat[0].length;
        int[] indices = new int[rows];
        boolean flag = true;
        int curElement = 0;
        while (flag) {
            int count = 0;
            for (int i = 0; i < rows; i++) {
                int element = mat[i][indices[i]];
                curElement = Math.max(curElement, element);
            }
            for (int i = 0; i < rows; i++) {
                int element = mat[i][indices[i]];
                if (element == curElement)
                    count++;
                else if (element < curElement) {
                    indices[i]++;
                    if (indices[i] >= columns) {
                        flag = false;
                        break;
                    }
                }
            }
            if (count == rows)
                return curElement;
        }
        return -1;
    }
}
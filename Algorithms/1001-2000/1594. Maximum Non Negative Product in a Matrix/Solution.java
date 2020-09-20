class Solution {
    public int maxProductPath(int[][] grid) {
        final int MODULO = 1000000007;
        long maxProduct = -1;
        int rows = grid.length, columns = grid[0].length;
        long[][][] products = new long[rows][columns][2];
        products[0][0][0] = products[0][0][1] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            long product = products[i - 1][0][0] * grid[i][0];
            if (product == 0 && maxProduct < 0)
                maxProduct = 0;
            products[i][0][0] = products[i][0][1] = product;
        }
        for (int j = 1; j < columns; j++) {
            long product = products[0][j - 1][0] * grid[0][j];
            if (product == 0 && maxProduct < 0)
                maxProduct = 0;
            products[0][j][0] = products[0][j][1] = product;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                int num = grid[i][j];
                if (num == 0 && maxProduct < 0)
                    maxProduct = 0;
                long product1 = products[i - 1][j][0] * num;
                long product2 = products[i - 1][j][1] * num;
                long product3 = products[i][j - 1][0] * num;
                long product4 = products[i][j - 1][1] * num;
                long[] array = {product1, product2, product3, product4};
                Arrays.sort(array);
                long min = array[0], max = array[3];
                if (max > 0)
                    products[i][j][0] = max;
                else
                    products[i][j][0] = min;
                if (min < 0)
                    products[i][j][1] = min;
                else
                    products[i][j][1] = max;
            }
        }
        maxProduct = Math.max(maxProduct, Math.max(products[rows - 1][columns - 1][0], products[rows - 1][columns - 1][1]));
        return (int) (maxProduct % MODULO);
    }
}
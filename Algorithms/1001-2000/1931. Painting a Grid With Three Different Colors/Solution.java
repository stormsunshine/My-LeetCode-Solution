class Solution {
    public int colorTheGrid(int m, int n) {
        final int MODULO = 1000000007;
        List<Integer> types = new ArrayList<Integer>();
        int maxCount = (int) Math.pow(3, m);
        for (int i = 0; i < maxCount; i++) {
            if (adjacentDistinct(i, m))
                types.add(i);
        }
        int typeCnt = types.size();
        int[][] related = new int[typeCnt][typeCnt];
        for (int i = 0; i < typeCnt; i++) {
            int type1 = types.get(i);
            int[] arr1 = new int[m];
            for (int k = m - 1; k >= 0 && type1 > 0; k--) {
                arr1[k] = type1 % 3;
                type1 /= 3;
            }
            for (int j = 0; j < typeCnt; j++) {
                int type2 = types.get(j);
                int[] arr2 = new int[m];
                for (int k = m - 1; k >= 0 && type2 > 0; k--) {
                    arr2[k] = type2 % 3;
                    type2 /= 3;
                }
                boolean flag = true;
                for (int k = 0; k < m; k++) {
                    if (arr1[k] == arr2[k]) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    related[i][j] = 1;
            }
        }
        int[][] f = new int[n + 1][typeCnt];
        for (int i = 0; i < typeCnt; i++)
            f[1][i] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < typeCnt; j++) {
                for (int k = 0; k < typeCnt; k++) {
                    if (related[k][j] != 0)
                        f[i][j] = (f[i][j] + f[i - 1][k]) % MODULO;
                }
            }
        }
        int count = 0;
        for (int j = 0; j < typeCnt; j++)
            count = (count + f[n][j]) % MODULO;
        return count;
    }

    public boolean adjacentDistinct(int num, int m) {
        int prev = -1;
        for (int i = 0; i < m; i++) {
            int curr = num % 3;
            if (curr == prev)
                return false;
            prev = curr;
            num /= 3;
        }
        return true;
    }
}
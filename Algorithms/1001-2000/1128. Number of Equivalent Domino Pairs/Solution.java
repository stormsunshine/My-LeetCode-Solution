class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int length = dominoes.length;
        for (int i = 0; i < length; i++) {
            int[] domino = dominoes[i];
            if (domino[0] > domino[1]) {
                int temp = domino[0];
                dominoes[i][0] = dominoes[i][1];
                dominoes[i][1] = temp;
            }
        }
        Arrays.sort(dominoes, new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2) {
                if (array1[0] != array2[0])
                    return array1[0] - array2[0];
                else
                    return array1[1] - array2[1];
            }
        });
        int equivalentCount = 0;
        int consecutive = 1;
        for (int i = 1; i < length; i++) {
            int[] prevDomino = dominoes[i - 1];
            int[] curDomino = dominoes[i];
            if (prevDomino[0] == curDomino[0] && prevDomino[1] == curDomino[1])
                consecutive++;
            else {
                equivalentCount += consecutive * (consecutive - 1) / 2;
                consecutive = 1;
            }
        }
        if (consecutive > 1)
            equivalentCount += consecutive * (consecutive - 1) / 2;
        return equivalentCount;
    }
}
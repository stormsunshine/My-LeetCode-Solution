class Solution {
    public int getKth(int lo, int hi, int k) {
        int length = hi - lo + 1;
        int[][] array = new int[length][2];
        for (int i = 0; i < length; i++) {
            array[i][0] = lo + i;
            array[i][1] = getPower(lo + i);
        }
        Arrays.sort(array, new Comparator<int[]>() {
            public int compare(int[] element1, int[] element2) {
                if (element1[1] != element2[1])
                    return element1[1] - element2[1];
                else
                    return element1[0] - element2[0];
            }
        });
        return array[k - 1][0];
    }

    public int getPower(int num) {
        int power = 0;
        while (num != 1) {
            if (num % 2 == 0)
                num /= 2;
            else
                num = 3 * num + 1;
            power++;
        }
        return power;
    }
}
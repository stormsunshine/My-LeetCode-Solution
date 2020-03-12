class Solution {
    public boolean isSelfCrossing(int[] x) {
        int length = x.length;
        if (length < 4)
            return false;
        int[] array = new int[6];
        System.arraycopy(x, 0, array, 3, 3);
        for (int i = 3; i < length; i++) {
            for (int j = 1; j < 6; j++)
                array[j - 1] = array[j];
            array[5] = x[i];
            if (array[4] <= array[2] - array[0] && array[5] >= array[3])
                return true;
            else {
                if (array[2] - array[0] <= array[4] && array[4] <= array[2]) {
                    int prev = array[3] - array[1] < 0 ? array[3] : array[3] - array[1];
                    if (array[5] >= prev)
                        return true;
                }
            }
        }
        return false;
    }
}
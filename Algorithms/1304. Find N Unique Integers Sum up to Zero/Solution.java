class Solution {
    public int[] sumZero(int n) {
        int[] array = new int[n];
        if (n == 1)
            array[0] = 0;
        else {
            if (n % 2 == 0) {
                for (int i = 1; i < n; i += 2) {
                    array[i - 1] = -i;
                    array[i] = i;
                }
            } else {
                for (int i = 1; i < n; i += 2) {
                    array[i] = i;
                    array[i + 1] = -i;
                }
            }
        }
        return array;
    }
}
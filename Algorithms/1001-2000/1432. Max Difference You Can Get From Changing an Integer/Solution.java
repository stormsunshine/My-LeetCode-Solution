class Solution {
    public int maxDiff(int num) {
        int max = getMax(num), min = getMin(num);
        return max - min;
    }

    public int getMax(int num) {
        char[] array = String.valueOf(num).toCharArray();
        int length = array.length;
        char original = '0';
        for (int i = 0; i < length; i++) {
            if (array[i] != '9') {
                original = array[i];
                break;
            }
        }
        for (int i = 0; i < length; i++) {
            if (array[i] == original)
                array[i] = '9';
        }
        return Integer.parseInt(new String(array));
    }

    public int getMin(int num) {
        char[] array = String.valueOf(num).toCharArray();
        int length = array.length;
        if (array[0] == '1') {
            char original = '0';
            for (int i = 1; i < length; i++) {
                if (array[i] != '0' && array[i] != '1') {
                    original = array[i];
                    break;
                }
            }
            for (int i = 1; i < length; i++) {
                if (array[i] == original)
                    array[i] = '0';
            }
        } else {
            char original = array[0];
            for (int i = 0; i < length; i++) {
                if (array[i] == original)
                    array[i] = '1';
            }
        }
        return Integer.parseInt(new String(array));
    }
}
class Solution {
    public int getMinSwaps(String num, int k) {
        int minSwaps = 0;
        char[] swapped = num.toCharArray();
        for (int i = 1; i <= k; i++)
            nextPermutation(swapped);
        char[] original = num.toCharArray();
        int length = original.length;
        for (int i = 0; i < length; i++) {
            if (swapped[i] != original[i]) {
                for (int j = i + 1; j < length; j++) {
                    if (swapped[i] == original[j]) {
                        for (int m = j - 1; m >= i; m--) {
                            original[m + 1] = original[m];
                            minSwaps++;
                        }
                        original[i] = swapped[i];
                        break;
                    }
                }
            }
        }
        return minSwaps;
    }

    public void nextPermutation(char[] array) {
        int i = array.length - 2;
        while (i >= 0 && array[i] >= array[i + 1])
            i--;
        if (i >= 0) {
            int j = array.length - 1;
            while (j >= 0 && array[i] >= array[j])
                j--;
            swap(array, i, j);
        }
        reverse(array, i + 1);
    }

    public void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void reverse(char[] array, int start) {
        int left = start, right = array.length - 1;
        while (left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
    }
}
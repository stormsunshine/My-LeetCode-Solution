class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> list = new ArrayList<Integer>();
        int length = A.length;
        for (int i = length; i >= 1; i--) {
            if (A[i - 1] != i) {
                int flipIndex = 0;
                for (int j = length - 1; j >= 0; j--) {
                    if (A[j] == i) {
                        flipIndex = j;
                        break;
                    }
                }
                if (flipIndex > 0) {
                    pancakeFlip(A, flipIndex);
                    list.add(flipIndex + 1);
                }
                pancakeFlip(A, i - 1);
                list.add(i);
            }
        }
        return list;
    }

    public void pancakeFlip(int[] array, int index) {
        int left = 0, right = index;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
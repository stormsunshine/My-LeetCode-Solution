class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> orderMap = new HashMap<Integer, Integer>();
        int length1 = arr1.length, length2 = arr2.length;
        for (int i = 0; i < length2; i++) {
            int num = arr2[i];
            orderMap.put(num, i);
        }
        for (int i = 1; i < length1; i++) {
            int num = arr1[i];
            int order = orderMap.getOrDefault(num, Integer.MAX_VALUE);
            int insertIndex = -1;
            for (int j = i - 1; j >= 0; j--) {
                int curOrder = orderMap.getOrDefault(arr1[j], Integer.MAX_VALUE);
                if (curOrder < order || curOrder == order && arr1[j] < num) {
                    insertIndex = j;
                    break;
                }
                arr1[j + 1] = arr1[j];
            }
            insertIndex++;
            arr1[insertIndex] = num;
        }
        return arr1;
    }
}
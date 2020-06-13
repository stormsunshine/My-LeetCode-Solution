class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        List<int[]> indices = new ArrayList<int[]>();
        int length = arr.length;
        int sum = 0;
        int start = 0, end = 0;
        while (end < length) {
            sum += arr[end];
            while (sum > target) {
                sum -= arr[start];
                start++;
            }
            if (sum == target) {
                indices.add(new int[]{start, end});
                sum -= arr[start];
                start++;
            }
            end++;
        }
        int size = indices.size();
        if (size <= 1)
            return -1;
        Collections.sort(indices, new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2) {
                if (array1[1] - array1[0] != array2[1] - array2[0])
                    return (array1[1] - array1[0]) - (array2[1] - array2[0]);
                else
                    return array1[0] - array2[0];
            }
        });
        int[] array0 = indices.get(0);
        int length1 = array0[1] - array0[0] + 1;
        int length2 = Integer.MAX_VALUE;
        for (int i = 1; i < size; i++) {
            int[] array = indices.get(i);
            int curLength = array[1] - array[0] + 1;
            if (array[0] > array0[1] || array[1] < array0[0]) {
                length2 = curLength;
                return length1 + length2;
            }
            if (curLength > length1) {
                for (int j = 0; j < i; j++) {
                    int[] prevArray = indices.get(j);
                    int prevLength = prevArray[1] - prevArray[0] + 1;
                    if (prevLength == length1 && (array[0] > prevArray[1] || array[1] < prevArray[0])) {
                        length2 = curLength;
                        return length1 + length2;
                    }
                }
            }
        }
        return -1;
    }
}
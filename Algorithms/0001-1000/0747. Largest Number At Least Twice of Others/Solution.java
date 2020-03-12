class Solution {
    public int dominantIndex(int[] nums) {
        int length = nums.length;
        if (length == 1)
            return 0;
        int[][] numIndexArray = new int[length][2];
        for (int i = 0; i < length; i++) {
            numIndexArray[i][0] = nums[i];
            numIndexArray[i][1] = i;
        }
        Arrays.sort(numIndexArray, new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2) {
                if (array1[0] != array2[0])
                    return array1[0] - array2[0];
                else
                    return array1[1] - array2[1];
            }
        });
        int maxNum = numIndexArray[length - 1][0], maxIndex = numIndexArray[length - 1][1];
        int secondMaxNum = numIndexArray[length - 2][0];
        return maxNum >= 2 * secondMaxNum ? maxIndex : -1;
    }
}
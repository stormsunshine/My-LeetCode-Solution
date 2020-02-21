class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int length = arr1.length;
        int[][] nums = new int[4][length];
        for (int i = 0; i < length; i++) {
            nums[0][i] = arr1[i] + arr2[i];
            nums[1][i] = arr1[i] - arr2[i];
            nums[2][i] = -arr1[i] + arr2[i];
            nums[3][i] = -arr1[i] - arr2[i];
        }
        int maxValue = 0;
        for (int i = 0; i < 4; i++) {
            int curValue = maxValExpr(nums[i]);
            maxValue = Math.max(maxValue, curValue);
        }
        return maxValue;
    }

    public int maxValExpr(int[] arr) {
        int length = arr.length;
        int[] arr1 = new int[length];
        int[] arr2 = new int[length];
        for (int i = 0; i < length; i++) {
            arr1[i] = i + arr[i];
            arr2[i] = i - arr[i];
        }
        int maxDifference1 = maxDifference(arr1);
        int maxDifference2 = maxDifference(arr2);
        return Math.max(maxDifference1, maxDifference2);
    }

    public int maxDifference(int[] arr) {
        int min = Integer.MAX_VALUE;
        int length = arr.length;
        int maxDifference = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if (arr[i] < min)
                min = arr[i];
            else if (arr[i] - min > maxDifference)
                maxDifference = arr[i] - min;
        }
        return maxDifference;
    }
}
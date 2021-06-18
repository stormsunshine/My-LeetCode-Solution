class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int low = 0, high = m - 1, maxIndex = 0;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            maxIndex = getMaxIndex(mat[mid], n);
            if (mat[mid][maxIndex] < mat[mid + 1][maxIndex])
                low = mid + 1;
            else
                high = mid;
        }
		maxIndex = getMaxIndex(mat[low], n);
        return new int[]{low, maxIndex};
    }
    
    public int getMaxIndex(int[] arr, int n) {
        int index = 0, maxNum = 0;
        for (int i = 0; i < n; i++) {
            if (maxNum < arr[i]) {
                maxNum = arr[i];
                index = i;
            }
        }
        return index;
    }
}
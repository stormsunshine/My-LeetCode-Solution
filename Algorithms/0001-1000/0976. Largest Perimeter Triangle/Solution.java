class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int length = A.length;
        for (int i = length - 1; i >= 2; i--) {
            int side1 = A[i], side2 = A[i - 1], side3 = A[i - 2];
            if (side2 + side3 > side1)
                return side1 + side2 + side3;
        }
        return 0;
    }
}
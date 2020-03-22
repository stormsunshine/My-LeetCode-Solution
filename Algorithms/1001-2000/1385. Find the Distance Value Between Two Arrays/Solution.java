class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        int length1 = arr1.length, length2 = arr2.length;
        for (int i = 0; i < length1; i++) {
            int num1 = arr1[i];
            boolean flag = true;
            for (int j = 0; j < length2; j++) {
                int num2 = arr2[j];
                if (Math.abs(num1 - num2) <= d) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                count++;
        }
        return count;
    }
}
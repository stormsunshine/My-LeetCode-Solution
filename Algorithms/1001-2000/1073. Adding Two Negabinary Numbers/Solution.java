class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int length1 = arr1.length, length2 = arr2.length;
        int sumLength = Math.max(length1, length2) + 2;
        int[] arr1Ext = new int[sumLength];
        System.arraycopy(arr1, 0, arr1Ext, sumLength - length1, length1);
        int[] arr2Ext = new int[sumLength];
        System.arraycopy(arr2, 0, arr2Ext, sumLength - length2, length2);
        int[] sumArr = new int[sumLength];
        for (int i = sumLength - 1; i > 0; i--) {
            sumArr[i] += arr1Ext[i] + arr2Ext[i];
            int carry = sumArr[i] >> 1;
            sumArr[i] -= carry * 2;
            sumArr[i - 1] -= carry;
        }
        int startIndex = sumLength - 1;
        for (int i = 0; i < sumLength; i++) {
            if (sumArr[i] != 0) {
                startIndex = i;
                break;
            }
        }
        int trimLength = sumLength - startIndex;
        int[] sumArrTrim = new int[trimLength];
        System.arraycopy(sumArr, startIndex, sumArrTrim, 0, trimLength);
        return sumArrTrim;
    }
}
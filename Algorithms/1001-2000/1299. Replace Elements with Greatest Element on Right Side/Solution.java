class Solution {
    public int[] replaceElements(int[] arr) {
        if (arr == null || arr.length == 0)
            return arr;
        int length = arr.length;
        int[] newArray = new int[length];
        newArray[length - 1] = -1;
        if (length == 1)
            return newArray;
        newArray[length - 2] = arr[length - 1];
        for (int i = length - 3; i >= 0; i--) {
            int nextNum = arr[i + 1];
            newArray[i] = Math.max(newArray[i + 1], nextNum);
        }
        return newArray;
    }
}
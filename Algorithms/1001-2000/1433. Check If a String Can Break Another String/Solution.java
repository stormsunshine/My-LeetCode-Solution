class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        int difference = 0;
        int length = array1.length;
        for (int i = 0; i < length; i++) {
            int curDifference = array1[i] - array2[i];
            if (curDifference != 0) {
                curDifference /= Math.abs(curDifference);
                if (curDifference * difference < 0)
                    return false;
                else
                    difference = curDifference;
            }
        }
        return true;
    }
}
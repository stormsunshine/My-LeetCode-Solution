class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        boolean flag = true;
        for (int i = 0; i < length; i++) {
            if (digits[i] != 9) {
                flag = false;
                break;
            }
        }
        if (flag) {
            int[] newArray = new int[length + 1];
            newArray[0] = 1;
            return newArray;
        }
        int[] ret = new int[length];
        for (int i = 0; i < length; i++)
            ret[i] = digits[i];
        ret[length - 1]++;
        int index = length - 1;
        while (index > 0 && ret[index] >= 10) {
            int carry = ret[index] / 10;
            ret[index] %= 10;
            ret[index - 1] += carry;
            index--;
        }
        return ret;
    }
}
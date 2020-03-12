class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        char[] array = String.valueOf(x).toCharArray();
        int index1 = 0, index2 = array.length - 1;
        while (index1 < index2) {
            if (array[index1] != array[index2])
                return false;
            index1++;
            index2--;
        }
        return true;
    }
}
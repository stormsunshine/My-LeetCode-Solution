class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] array = s.toCharArray();
        int length = array.length;
        int low = 0, high = length - 1;
        while (low < high) {
            while (low < length && !Character.isLetterOrDigit(array[low]))
                low++;
            while (high >= 0 && !Character.isLetterOrDigit(array[high]))
                high--;
            if (low >= high)
                break;
            if (array[low] != array[high])
                return false;
            low++;
            high--;
        }
        return true;
    }
}
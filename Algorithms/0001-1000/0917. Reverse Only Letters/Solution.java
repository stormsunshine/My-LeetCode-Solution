class Solution {
    public String reverseOnlyLetters(String S) {
        char[] array = S.toCharArray();
        int low = 0, high = array.length - 1;
        while (low < high) {
            char c1 = array[low], c2 = array[high];
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                array[low] = c2;
                array[high] = c1;
                low++;
                high--;
            } else {
                if (!Character.isLetter(c1))
                    low++;
                if (!Character.isLetter(c2))
                    high--;
            }
        }
        return new String(array);
    }
}
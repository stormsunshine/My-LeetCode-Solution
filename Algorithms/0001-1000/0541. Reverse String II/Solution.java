class Solution {
    public String reverseStr(String s, int k) {
        char[] array = s.toCharArray();
        int length = array.length;
        int group = k * 2;
        int begin = 0;
        while (begin < length) {
            int end = Math.min(begin + k - 1, length - 1);
            int low = begin, high = end;
            while (low < high) {
                char c1 = array[low], c2 = array[high];
                array[low] = c2;
                array[high] = c1;
                low++;
                high--;
            }
            begin += group;
        }
        return new String(array);
    }
}
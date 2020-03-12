class Solution {
    public int[] diStringMatch(String S) {
        int strLength = S.length();
        int length = strLength + 1;
        int[] array = new int[length];
        int min = 0, max = 0;
        for (int i = 1; i < length; i++) {
            char c = S.charAt(i - 1);
            int newNum = c == 'I' ? max + 1 : min - 1;
            array[i] = newNum;
            min = Math.min(min, newNum);
            max = Math.max(max, newNum);
        }
        if (min != 0) {
            for (int i = 0; i < length; i++)
                array[i] -= min;
        }
        return array;
    }
}
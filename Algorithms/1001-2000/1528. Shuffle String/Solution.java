class Solution {
    public String restoreString(String s, int[] indices) {
        int length = indices.length;
        char[] array = new char[length];
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int index = indices[i];
            array[index] = c;
        }
        return new String(array);
    }
}
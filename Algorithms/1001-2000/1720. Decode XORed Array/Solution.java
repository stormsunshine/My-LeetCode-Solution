class Solution {
    public int[] decode(int[] encoded, int first) {
        int length = encoded.length;
        int[] arr = new int[length + 1];
        arr[0] = first;
        for (int i = 0; i < length; i++)
            arr[i + 1] = arr[i] ^ encoded[i];
        return arr;
    }
}
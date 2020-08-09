class Solution {
    public char findKthBit(int n, int k) {
        String str = "0";
        for (int i = 2; i <= n; i++) {
            String prevInvert = invert(str);
            StringBuffer curr = new StringBuffer(str).append("1").append(new StringBuffer(prevInvert).reverse());
            str = curr.toString();
        }
        return str.charAt(k - 1);
    }

    public String invert(String str) {
        char[] array = str.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; i++)
            array[i] = (char) (1 - (array[i] - '0') + '0');
        return new String(array);
    }
}
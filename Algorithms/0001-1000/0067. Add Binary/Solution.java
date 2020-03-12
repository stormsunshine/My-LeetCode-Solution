class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        int indexA = arrayA.length - 1, indexB = arrayB.length - 1;
        while (indexA >= 0 && indexB >= 0) {
            arrayA[indexA] += arrayB[indexB] - '0';
            indexA--;
            indexB--;
        }
        for (int i = arrayA.length - 1; i > 0; i--) {
            if (arrayA[i] > '1') {
                int carry = (arrayA[i] - '0') / 2;
                int remainder = (arrayA[i] - '0') % 2;
                arrayA[i - 1] += carry;
                arrayA[i] = (char) (remainder + '0');
            }
        }
        String sumStr = new String(arrayA);
        if (sumStr.charAt(0) > '1') {
            int carry = (sumStr.charAt(0) - '0') / 2;
            int remainder = (sumStr.charAt(0) - '0') % 2;
            sumStr = "" + carry + remainder + sumStr.substring(1);
        }
        return sumStr;
    }
}
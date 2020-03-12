class Solution {
    public String encode(int num) {
        num++;
        int bits = (int) (Math.log(num) / Math.log(2));
        int difference = num - (int) Math.pow(2, bits);
        String encodeStr = binary(difference, bits);
        return encodeStr;
    }

    public String binary(int num, int bits) {
        String str = "";
        for (int i = 0; i < bits; i++) {
            int remainder = num % 2;
            str = remainder + str;
            num /= 2;
        }
        return str;
    }
}
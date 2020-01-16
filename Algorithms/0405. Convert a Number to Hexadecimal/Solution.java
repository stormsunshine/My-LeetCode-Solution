class Solution {
    public String toHex(int num) {
        if (num == 0)
            return "0";
        int[] bytes = new int[8];
        for (int i = 0; i < 8; i++) {
            int temp = (num >> 4 * i) & 0xf;
            bytes[7 - i] = temp;
        }
        String hex = "";
        boolean flag = false;
        for (int i = 0; i < 8; i++) {
            int curByte = bytes[i];
            if (!flag && curByte == 0)
                continue;
            hex += hexChar(curByte);
            flag = true;
        }
        return hex;
    }

    public char hexChar(int num) {
        if (num < 10)
            return (char) (num + '0');
        else
            return (char) (num - 10 + 'a');
    }
}
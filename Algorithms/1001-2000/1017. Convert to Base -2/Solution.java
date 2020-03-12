class Solution {
    public String baseNeg2(int N) {
        if (N == 0)
            return "0";
        int[] bits = new int[32];
        int remain = N;
        int index = 0;
        while (remain > 0) {
            bits[index] = remain % 2;
            remain /= 2;
            index++;
        }
        for (int i = 0; i <= 31; i++) {
            if (i % 2 == 1 && bits[i] == 1)
                bits[i + 1]++;
            while (bits[i] > 1) {
                bits[i] -= 2;
                bits[i + 1]++;
            }
        }
        StringBuffer sb = new StringBuffer();
        boolean flag = false;
        for (int i = 31; i >= 0; i--) {
            int bit = bits[i];
            if (flag)
                sb.append(bit);
            else {
                if (bit == 1) {
                    sb.append(bit);
                    flag = true;
                }
            }
        }
        return sb.toString();
    }
}
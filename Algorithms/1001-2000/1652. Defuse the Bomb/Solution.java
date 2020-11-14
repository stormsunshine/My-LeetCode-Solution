class Solution {
    public int[] decrypt(int[] code, int k) {
        int length = code.length;
        int[] decrypted = new int[length];
        if (k == 0)
            return decrypted;
        for (int i = 0; i < length; i++)
            decrypted[i] = getSum(code, i, k);
        return decrypted;
    }

    public int getSum(int[] code, int index, int k) {
        int sum = 0;
        int length = code.length;
        int direction = k > 0 ? 1 : -1;
        k = Math.abs(k);
        for (int i = 1; i <= k; i++) {
            int curIndex = (index + i * direction) % length;
            if (curIndex < 0)
                curIndex += length;
            sum += code[curIndex];
        }
        return sum;
    }
}
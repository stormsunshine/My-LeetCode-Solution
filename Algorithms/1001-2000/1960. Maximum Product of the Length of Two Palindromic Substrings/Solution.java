class Solution {
    public long maxProduct(String s) {
        int length = s.length();
        int[] span = new int[length];
        for (int i = 0, l = 0, r = -1; i < length; i++) {
            span[i] = i <= r ? Math.min(span[l + r - i], r - i + 1) : 1;
            while (i - span[i] >= 0 && i + span[i] < length && s.charAt(i - span[i]) == s.charAt(i + span[i]))
                span[i]++;
            if (i + span[i] - 1 > r) {
                l = i - span[i] + 1;
                r = i + span[i] - 1;
            }
        }
        int[] pre = new int[length];
        int[] suf = new int[length];
        for (int i = 0; i < length; i++) {
            pre[i + span[i] - 1] = Math.max(pre[i + span[i] - 1], span[i] * 2 - 1);
            suf[i - span[i] + 1] = Math.max(suf[i - span[i] + 1], span[i] * 2 - 1);
        }
        for (int i = 1; i < length; i++)
            pre[i] = Math.max(pre[i], pre[i - 1]);
        for (int i = length - 2; i >= 0; i--)
            pre[i] = Math.max(pre[i], pre[i + 1] - 2);
        for (int i = length - 2; i >= 0; i--)
            suf[i] = Math.max(suf[i], suf[i + 1]);
        for (int i = 1; i < length; i++)
            suf[i] = Math.max(suf[i], suf[i - 1] - 2);
        long product = 0;
        for (int i = 0; i < length - 1; i++)
            product = Math.max(product, (long) pre[i] * suf[i + 1]);
        return product;
    }
}
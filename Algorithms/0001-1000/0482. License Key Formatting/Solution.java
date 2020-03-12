class Solution {
    public String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase();
        S = S.replaceAll("-", "");
        int length = S.length();
        StringBuffer sb = new StringBuffer(S);
        int count = 0;
        for (int i = length - 1; i > 0; i--) {
            count++;
            if (count == K) {
                sb.insert(i, '-');
                count = 0;
            }
        }
        return sb.toString();
    }
}
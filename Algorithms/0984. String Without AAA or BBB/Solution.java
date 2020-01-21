class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuffer sb = new StringBuffer();
        while (A > B && B > 0) {
            sb.append("aab");
            A -= 2;
            B--;
        }
        while (A < B && A > 0) {
            sb.append("bba");
            B -= 2;
            A--;
        }
        while (A > 0 && B > 0) {
            sb.append("ab");
            A--;
            B--;
        }
        while (A > 0) {
            sb.append("a");
            A--;
        }
        while (B > 0) {
            sb.append("b");
            B--;
        }
        return sb.toString();
    }
}
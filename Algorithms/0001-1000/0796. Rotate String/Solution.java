class Solution {
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (B + B).indexOf(A) >= 0;
    }
}
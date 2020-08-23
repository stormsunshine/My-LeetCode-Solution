class Solution {
    public String thousandSeparator(int n) {
        StringBuffer sb = new StringBuffer(String.valueOf(n));
        for (int i = sb.length() - 3; i > 0; i -= 3)
            sb.insert(i, '.');
        return sb.toString();
    }
}
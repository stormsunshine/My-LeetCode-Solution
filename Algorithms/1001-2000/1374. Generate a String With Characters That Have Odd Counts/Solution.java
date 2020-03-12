class Solution {
    public String generateTheString(int n) {
        StringBuffer sb = new StringBuffer();
        if (n % 2 == 0) {
            sb.append('a');
            for (int i = 1; i < n; i++)
                sb.append('b');
        } else {
            for (int i = 0; i < n; i++)
                sb.append('a');
        }
        return sb.toString();
    }
}
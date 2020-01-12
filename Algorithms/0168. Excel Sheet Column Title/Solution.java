class Solution {
    public String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            n--;
            stringBuilder.append((char)(n % 26 + 'A'));
            n /= 26;
        }
        return stringBuilder.reverse().toString();
    }
}
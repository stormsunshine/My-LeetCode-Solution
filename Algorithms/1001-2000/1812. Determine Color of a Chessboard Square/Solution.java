class Solution {
    public boolean squareIsWhite(String coordinates) {
        int column = coordinates.charAt(0) - 'a' + 1;
        int row = coordinates.charAt(1) - '0';
        return column % 2 != row % 2;
    }
}
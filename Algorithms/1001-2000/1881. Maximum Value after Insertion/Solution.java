class Solution {
    public String maxValue(String n, int x) {
        char xChar = (char) (x + '0');
        if (n.charAt(0) != '-')
            return maxValuePositive(n, xChar);
        else
            return maxValueNegative(n, xChar);
    }

    public String maxValuePositive(String n, char x) {
        StringBuffer sb = new StringBuffer(n);
        int length = n.length();
        int insertIndex = length;
        for (int i = 0; i < length; i++) {
            if (n.charAt(i) < x) {
                insertIndex = i;
                break;
            }
        }
        sb.insert(insertIndex, x);
        return sb.toString();
    }

    public String maxValueNegative(String n, char x) {
        StringBuffer sb = new StringBuffer(n);
        int length = n.length();
        int insertIndex = length;
        for (int i = 1; i < length; i++) {
            if (n.charAt(i) > x) {
                insertIndex = i;
                break;
            }
        }
        sb.insert(insertIndex, x);
        return sb.toString();
    }
}
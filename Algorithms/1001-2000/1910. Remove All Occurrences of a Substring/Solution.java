class Solution {
    public String removeOccurrences(String s, String part) {
        int partLength = part.length();
        while (s.indexOf(part) >= 0) {
            int index = s.indexOf(part);
            s = s.substring(0, index) + s.substring(index + partLength);
        }
        return s;
    }
}
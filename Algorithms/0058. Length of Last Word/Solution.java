class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int length = s.length();
        int index = s.lastIndexOf(" ");
        return length - (index + 1);
    }
}
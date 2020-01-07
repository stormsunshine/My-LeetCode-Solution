class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        while (s.indexOf("  ") >= 0)
            s = s.replaceAll("  ", " ");
        String[] array = s.split(" ");
        int length = array.length;
        StringBuffer reverseSB = new StringBuffer();
        for (int i = length - 1; i >= 0; i--) {
            reverseSB.append(" ");
            reverseSB.append(array[i]);
        }
        reverseSB.deleteCharAt(0);
        String reverse = reverseSB.toString();
        return reverse;
    }
}
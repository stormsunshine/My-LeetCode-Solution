class Solution {
    public String arrangeWords(String text) {
        text = text.toLowerCase();
        String[] array = text.split(" ");
        Arrays.sort(array, new Comparator<String>() {
            public int compare(String str1, String str2) {
                return str1.length() - str2.length();
            }
        });
        int length = array.length;
        StringBuffer sb = new StringBuffer();
        sb.append(array[0]);
        sb.setCharAt(0, (char) (array[0].charAt(0) - ('a' - 'A')));
        for (int i = 1; i < length; i++) {
            sb.append(' ');
            sb.append(array[i]);
        }
        return sb.toString();
    }
}
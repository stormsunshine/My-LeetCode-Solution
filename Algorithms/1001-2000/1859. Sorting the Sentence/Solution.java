class Solution {
    public String sortSentence(String s) {
        String[] array = s.split(" ");
        int length = array.length;
        String[] newArray = new String[length];
        for (int i = 0; i < length; i++) {
            int wordLength = array[i].length();
            String word = array[i].substring(0, wordLength - 1);
            int index = array[i].charAt(wordLength - 1) - '0' - 1;
            newArray[index] = word;
        }
        StringBuffer sb = new StringBuffer(newArray[0]);
        for (int i = 1; i < length; i++)
            sb.append(" " + newArray[i]);
        return sb.toString();
    }
}
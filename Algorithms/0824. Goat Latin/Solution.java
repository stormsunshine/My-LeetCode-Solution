class Solution {
    public String toGoatLatin(String S) {
        String[] array = S.split(" ");
        int length = array.length;
        for (int i = 0; i < length; i++) {
            String str = array[i];
            if (beginWithVowel(str))
                str += "ma";
            else
                str = str.substring(1) + str.charAt(0) + "ma";
            for (int j = 0; j <= i; j++)
                str += "a";
            array[i] = str;
        }
        String goatLatin = "";
        for (int i = 0; i < length; i++) {
            if (i > 0)
                goatLatin += " ";
            goatLatin += array[i];
        }
        return goatLatin;
    }

    public boolean beginWithVowel(String str) {
        char firstChar = str.charAt(0);
        return firstChar == 'A' || firstChar == 'E' || firstChar == 'I' || firstChar == 'O' || firstChar == 'U' || firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u';
    }
}
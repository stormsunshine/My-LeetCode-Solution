class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        StringBuffer sb3 = new StringBuffer();
        int length1 = firstWord.length(), length2 = secondWord.length(), length3 = targetWord.length();
        for (int i = 0; i < length1; i++)
            sb1.append((char) (firstWord.charAt(i) - 'a' + '0'));
        for (int i = 0; i < length2; i++)
            sb2.append((char) (secondWord.charAt(i) - 'a' + '0'));
        for (int i = 0; i < length3; i++)
            sb3.append((char) (targetWord.charAt(i) - 'a' + '0'));
        int num1 = Integer.parseInt(sb1.toString());
        int num2 = Integer.parseInt(sb2.toString());
        int num3 = Integer.parseInt(sb3.toString());
        return num1 + num2 == num3;
    }
}
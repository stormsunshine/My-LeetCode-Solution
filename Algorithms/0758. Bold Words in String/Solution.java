class Solution {
    public String boldWords(String[] words, String S) {
        int length = S.length();
        boolean[] bold = new boolean[length];
        for (String word : words) {
            int wordLength = word.length();
            int beginIndex = 0;
            while (beginIndex >= 0) {
                beginIndex = S.indexOf(word, beginIndex);
                if (beginIndex >= 0) {
                    for (int i = 0; i < wordLength; i++)
                        bold[beginIndex + i] = true;
                    beginIndex++;
                }
            }
        }
        StringBuffer sb = new StringBuffer(S);
        if (bold[length - 1])
            sb.append("</b>");
        for (int i = length - 1; i > 0; i--) {
            if (bold[i] && !bold[i - 1])
                sb.insert(i, "<b>");
            else if (!bold[i] && bold[i - 1])
                sb.insert(i, "</b>");
        }
        if (bold[0])
            sb.insert(0, "<b>");
        String boldStr = sb.toString();
        return boldStr;
    }
}
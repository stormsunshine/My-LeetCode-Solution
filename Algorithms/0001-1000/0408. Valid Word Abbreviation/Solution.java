class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        List<String> abbrList = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        int abbrLength = abbr.length();
        for (int i = 0; i < abbrLength; i++) {
            char c = abbr.charAt(i);
            if (c >= 'A') {
                if (sb.length() > 0) {
                    abbrList.add(sb.toString());
                    sb = new StringBuffer();
                }
                abbrList.add(String.valueOf(c));
            } else
                sb.append(c);
        }
        if (sb.length() > 0)
            abbrList.add(sb.toString());
        int wordLength = word.length();
        int abbrListLength = abbrList.size();
        int wordIndex = 0;
        int abbrIndex = 0;
        while (wordIndex < wordLength && abbrIndex < abbrListLength) {
            String curAbbr = abbrList.get(abbrIndex);
            if (curAbbr.charAt(0) >= 'A') {
                char abbrChar = curAbbr.charAt(0);
                char c = word.charAt(wordIndex);
                if (abbrChar != c)
                    return false;
                else {
                    wordIndex++;
                    abbrIndex++;
                }
            } else {
                if (curAbbr.charAt(0) == '0')
                    return false;
                int skip = Integer.parseInt(curAbbr);
                wordIndex += skip;
                abbrIndex++;
            }
        }
        return wordIndex == wordLength && abbrIndex == abbrListLength;
    }
}
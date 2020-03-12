class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> abbreviations = new ArrayList<String>();
        abbreviations.add(word);
        int length = word.length();
        boolean[] isAbbr = new boolean[length];
        while (nextAbbreviation(isAbbr)) {
            String abbr = generateAbbreviation(word, isAbbr);
            abbreviations.add(abbr);
        }
        return abbreviations;
    }

    public String generateAbbreviation(String word, boolean[] isAbbr) {
        StringBuffer sb = new StringBuffer();
        int consecutiveCount = 0;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            if (isAbbr[i])
                consecutiveCount++;
            else {
                if (consecutiveCount > 0) {
                    sb.append(consecutiveCount);
                    consecutiveCount = 0;
                }
                sb.append(word.charAt(i));
            }
        }
        if (consecutiveCount > 0)
            sb.append(consecutiveCount);
        return sb.toString();
    }

    public boolean nextAbbreviation(boolean[] isAbbr) {
        int length = isAbbr.length;
        int lastFalseIndex = -1;
        for (int i = length - 1; i >= 0; i--) {
            if (!isAbbr[i]) {
                lastFalseIndex = i;
                break;
            }
        }
        if (lastFalseIndex < 0)
            return false;
        isAbbr[lastFalseIndex] = true;
        for (int i = lastFalseIndex + 1; i < length; i++)
            isAbbr[i] = false;
        return true;
    }
}
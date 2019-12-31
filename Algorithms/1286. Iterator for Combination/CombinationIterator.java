class CombinationIterator {
    char[] charactersArray;
    int charactersCount;
    int combinationLength;
    int[] curCombination;
    boolean hasNext;

    public CombinationIterator(String characters, int combinationLength) {
        charactersArray = characters.toCharArray();
        charactersCount = charactersArray.length;
        this.combinationLength = combinationLength;
        curCombination = new int[charactersCount];
        for (int i = 0; i < combinationLength; i++)
            curCombination[i] = 1;
        hasNext = true;
    }
    
    public String next() {
        StringBuffer sb = new StringBuffer();
        int beginIndex = -1;
        for (int i = 0; i < charactersCount; i++) {
            if (curCombination[i] == 1) {
                sb.append(charactersArray[i]);
                if (beginIndex < 0)
                    beginIndex = i;
            }
        }
        if (beginIndex == charactersCount - combinationLength)
            hasNext = false;
        else {
            int lastIndex = charactersCount;
            int count = 0;
            for (int i = charactersCount - 1; i >= 0; i--) {
                if (i < charactersCount - 1 && curCombination[i] == 1 && curCombination[i + 1] == 0) {
                    lastIndex = i + 1;
                    break;
                }
                if (curCombination[i] == 1)
                    count++;
            }
            curCombination[lastIndex - 1] = 0;
            curCombination[lastIndex] = 1;
            for (int i = 1; i <= count; i++)
                curCombination[lastIndex + i] = 1;
            for (int i = lastIndex + count + 1; i < charactersCount; i++)
                curCombination[i] = 0;
        }
        return sb.toString();
    }
    
    public boolean hasNext() {
        return hasNext;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
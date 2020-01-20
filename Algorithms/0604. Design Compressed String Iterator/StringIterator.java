class StringIterator {
    char[] letters;
    int[] counts;
    int length;
    int index;

    public StringIterator(String compressedString) {
        StringBuffer sb = new StringBuffer(compressedString);
        int compressedLength = sb.length();
        for (int i = compressedLength - 1; i >= 1; i--) {
            char curC = sb.charAt(i), prevC = sb.charAt(i - 1);
            if (Character.isDigit(curC) && Character.isLetter(prevC))
                sb.insert(i, ',');
            else if (Character.isLetter(curC) && Character.isDigit(prevC))
                sb.insert(i, ';');
        }
        String[] array = sb.toString().split(";");
        length = array.length;
        letters = new char[length];
        counts = new int[length];
        for (int i = 0; i < length; i++) {
            String letterCount = array[i];
            String[] letterCountArray = letterCount.split(",");
            letters[i] = letterCountArray[0].charAt(0);
            counts[i] = Integer.parseInt(letterCountArray[1]);
        }
        index = 0;
    }
    
    public char next() {
        if (hasNext()) {
            char curChar = letters[index];
            counts[index]--;
            if (counts[index] == 0)
                index++;
            return curChar;
        } else
            return ' ';
    }
    
    public boolean hasNext() {
        return index < length;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
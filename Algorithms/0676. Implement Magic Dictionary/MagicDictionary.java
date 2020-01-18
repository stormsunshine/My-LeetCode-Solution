class MagicDictionary {
    String[] dictArray;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        int length = dict.length;
        dictArray = new String[length];
        for (int i = 0; i < length; i++)
            dictArray[i] = dict[i];
        Arrays.sort(dictArray, new Comparator<String>() {
            public int compare(String str1, String str2) {
                if (str1.length() != str2.length())
                    return str1.length() - str2.length();
                else
                    return str1.compareTo(str2);
            }
        });
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        int wordLength = word.length();
        int index = binarySearch(dictArray, wordLength);
        if (index < 0)
            return false;
        if (difference(dictArray[index], word) == 1)
            return true;
        int index1 = index - 1, index2 = index + 1;
        while (index1 >= 0) {
            if (difference(dictArray[index1], word) == 1)
                return true;
            index1--;
        }
        while (index2 < dictArray.length) {
            if (difference(dictArray[index2], word) == 1)
                return true;
            index2++;
        }
        return false;
    }

    public int binarySearch(String[] array, int wordLength) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            String word = array[mid];
            if (word.length() == wordLength)
                return mid;
            else if (word.length() > wordLength)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -low - 1;
    }

    public int difference(String str1, String str2) {
        if (str1.length() != str2.length())
            return 2;
        if (str1.equals(str2))
            return 0;
        int difference = 0;
        int length = str1.length();
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                difference++;
                if (difference > 1)
                    return difference;
            }
        }
        return difference;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
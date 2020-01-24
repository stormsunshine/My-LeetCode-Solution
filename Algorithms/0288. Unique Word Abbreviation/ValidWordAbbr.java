class ValidWordAbbr {
    Map<String, List<String>> abbrWordsMap;

    public ValidWordAbbr(String[] dictionary) {
        abbrWordsMap = new HashMap<String, List<String>>();
        for (String word : dictionary) {
            String abbr = getAbbr(word);
            List<String> wordsList = abbrWordsMap.getOrDefault(abbr, new ArrayList<String>());
            if (!wordsList.contains(word)) {
                wordsList.add(word);
                abbrWordsMap.put(abbr, wordsList);
            }
        }
    }
    
    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        List<String> list = abbrWordsMap.getOrDefault(abbr, new ArrayList<String>());
        int size = list.size();
        if (size == 0)
            return true;
        else if (size == 1)
            return word.equals(list.get(0));
        else
            return false;
    }

    private String getAbbr(String word) {
        int length = word.length();
        if (length <= 2)
            return word;
        else
            return String.valueOf(word.charAt(0)) + (length - 2) + word.charAt(length - 1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
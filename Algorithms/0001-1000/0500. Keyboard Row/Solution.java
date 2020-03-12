class Solution {
    public String[] findWords(String[] words) {
        Map<Character, Integer> letterRowMap = new HashMap<Character, Integer>();
        letterRowMap.put('q', 1);
        letterRowMap.put('w', 1);
        letterRowMap.put('e', 1);
        letterRowMap.put('r', 1);
        letterRowMap.put('t', 1);
        letterRowMap.put('y', 1);
        letterRowMap.put('u', 1);
        letterRowMap.put('i', 1);
        letterRowMap.put('o', 1);
        letterRowMap.put('p', 1);
        letterRowMap.put('a', 2);
        letterRowMap.put('s', 2);
        letterRowMap.put('d', 2);
        letterRowMap.put('f', 2);
        letterRowMap.put('g', 2);
        letterRowMap.put('h', 2);
        letterRowMap.put('j', 2);
        letterRowMap.put('k', 2);
        letterRowMap.put('l', 2);
        letterRowMap.put('z', 3);
        letterRowMap.put('x', 3);
        letterRowMap.put('c', 3);
        letterRowMap.put('v', 3);
        letterRowMap.put('b', 3);
        letterRowMap.put('n', 3);
        letterRowMap.put('m', 3);
        List<String> wordsList = new ArrayList<String>();
        for (String word : words) {
            String lowerCaseWord = word.toLowerCase();
            boolean flag = true;
            char[] array = lowerCaseWord.toCharArray();
            if (array.length == 0) {
                wordsList.add(word);
                continue;
            }
            char c0 = array[0];
            int prevRow = letterRowMap.get(c0);
            for (char c : array) {
                int curRow = letterRowMap.get(c);
                if (curRow != prevRow) {
                    flag = false;
                    break;
                }
                prevRow = curRow;
            }
            if (flag)
                wordsList.add(word);
        }
        int length = wordsList.size();
        String[] rowWords = new String[length];
        for (int i = 0; i < length; i++)
            rowWords[i] = wordsList.get(i);
        return rowWords;
    }
}
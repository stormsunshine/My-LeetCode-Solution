class Solution {
    Set<String> match;
    Map<String, String> matchIgnoreCase;
    Map<String, String> matchIgnoreVowel;

    public String[] spellchecker(String[] wordlist, String[] queries) {
        match = new HashSet<String>();
        matchIgnoreCase = new HashMap<String, String>();
        matchIgnoreVowel = new HashMap<String, String>();
        int listLength = wordlist.length;
        for (int i = 0; i < listLength; i++) {
            String word = wordlist[i];
            match.add(word);
            String wordLower = word.toLowerCase();
            matchIgnoreCase.putIfAbsent(wordLower, word);
            String deVowel = deVowel(wordLower);
            matchIgnoreVowel.putIfAbsent(deVowel, word);
        }
        int length = queries.length;
        String[] answer = new String[length];
        for (int i = 0; i < length; i++) {
            String query = queries[i];
            String queryLower = query.toLowerCase();
            String queryLowerDeVowel = deVowel(queryLower);
            if (match.contains(query))
                answer[i] = query;
            else if (matchIgnoreCase.containsKey(queryLower))
                answer[i] = matchIgnoreCase.get(queryLower);
            else if (matchIgnoreVowel.containsKey(queryLowerDeVowel))
                answer[i] = matchIgnoreVowel.get(queryLowerDeVowel);
            else
                answer[i] = "";
        }
        return answer;
    }

    public String deVowel(String str) {
        char[] array = str.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (isVowel(array[i]))
                array[i] = '.';
        }
        return new String(array);
    }

    public boolean isVowel(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
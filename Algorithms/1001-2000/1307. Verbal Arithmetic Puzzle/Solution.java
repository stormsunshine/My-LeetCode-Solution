class Solution {
    public boolean isSolvable(String[] words, String result) {
        Map<Character, Integer> letterDigitMap = new HashMap<Character, Integer>();
        Set<Character> leadingSet = new HashSet<Character>();
        int resultLength = result.length();
        for (String word : words) {
            if (word.length() > resultLength)
                return false;
            if (word.length() > 1)
                leadingSet.add(word.charAt(0));
        }
        if (result.length() > 1)
            leadingSet.add(result.charAt(0));
        boolean[] used = new boolean[10];
        int[] carry = new int[resultLength + 1];
        return depthFirstSearch(words, result, letterDigitMap, leadingSet, used, carry, 0, 0);
    }

    public boolean depthFirstSearch(String[] words, String result, Map<Character, Integer> letterDigitMap, Set<Character> leadingSet, boolean[] used, int[] carry, int position, int wordIndex) {
        if (position == result.length())
            return carry[position] == 0;
        else if (wordIndex < words.length) {
            String word = words[wordIndex];
            int wordLength = word.length();
            if (wordLength <= position || letterDigitMap.containsKey(word.charAt(wordLength - position - 1)))
                return depthFirstSearch(words, result, letterDigitMap, leadingSet, used, carry, position, wordIndex + 1);
            else {
                char letter = word.charAt(wordLength - position - 1);
                int start = leadingSet.contains(letter) ? 1 : 0;
                for (int i = start; i <= 9; i++) {
                    if (!used[i]) {
                        used[i] = true;
                        letterDigitMap.put(letter, i);
                        boolean next = depthFirstSearch(words, result, letterDigitMap, leadingSet, used, carry, position, wordIndex + 1);
                        used[i] = false;
                        letterDigitMap.remove(letter);
                        if (next)
                            return true;
                    }
                }
            }
            return false;
        } else {
            int remain = carry[position];
            for (String word : words) {
                if (word.length() > position) {
                    char letter = word.charAt(word.length() - position - 1);
                    remain += letterDigitMap.get(letter);
                }
            }
            carry[position + 1] = remain / 10;
            remain %= 10;
            char letter = result.charAt(result.length() - position - 1);
            if (letterDigitMap.containsKey(letter) && letterDigitMap.get(letter) == remain)
                return depthFirstSearch(words, result, letterDigitMap, leadingSet, used, carry, position + 1, 0);
            else if (!letterDigitMap.containsKey(letter) && !used[remain] && !(leadingSet.contains(letter) && remain == 0)) {
                used[remain] = true;
                letterDigitMap.put(letter, remain);
                boolean next = depthFirstSearch(words, result, letterDigitMap, leadingSet, used, carry, position + 1, 0);
                used[remain] = false;
                letterDigitMap.remove(letter);
                return next;
            } else
                return false;
        }
    }
}
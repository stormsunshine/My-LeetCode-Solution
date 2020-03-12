class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ladders = new ArrayList<List<String>>();
        if (!wordList.contains(endWord))
            return ladders;
        Set<String> wordSet = new HashSet<String>(wordList);
        Queue<List<String>> queue = new LinkedList<List<String>>();
        List<String> path0 = new ArrayList<String>();
        path0.add(beginWord);
        queue.offer(path0);
        boolean isFound = false;
        Set<String> visitedSet = new HashSet<String>();
        visitedSet.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> curVisitedSet = new HashSet<String>();
            for (int i = 0; i < size; i++) {
                List<String> path = queue.poll();
                int lastIndex = path.size() - 1;
                String lastWord = path.get(lastIndex);
                List<String> nextWords = getNextWords(lastWord, wordSet);
                for (String word : nextWords) {
                    if (!visitedSet.contains(word)) {
                        if (word.equals(endWord)) {
                            isFound = true;
                            List<String> completePath = new ArrayList<String>(path);
                            completePath.add(word);
                            ladders.add(completePath);
                        }
                        List<String> nextPath = new ArrayList<String>(path);
                        nextPath.add(word);
                        queue.offer(nextPath);
                        curVisitedSet.add(word);
                    }
                }
            }
            visitedSet.addAll(curVisitedSet);
            if (isFound)
                break;
        }
        return ladders;
    }

    public List<String> getNextWords(String lastWord, Set<String> wordSet) {
        List<String> nextWords = new ArrayList<String>();
        char[] array = lastWord.toCharArray();
        int length = array.length;
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < length; i++) {
                if (array[i] == c)
                    continue;
                char prevC = array[i];
                array[i] = c;
                String newWord = new String(array);
                if (wordSet.contains(newWord))
                    nextWords.add(newWord);
                array[i] = prevC;
            }
        }
        return nextWords;
    }
}
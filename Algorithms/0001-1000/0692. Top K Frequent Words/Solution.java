class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            int count = map.getOrDefault(word, 0);
            count++;
            map.put(word, count);
        }
        PriorityQueue<WordCount> priorityQueue = new PriorityQueue<WordCount>();
        Set<String> keySet = map.keySet();
        for (String word : keySet) {
            int count = map.getOrDefault(word, 0);
            WordCount wordCount = new WordCount(word, count);
            priorityQueue.offer(wordCount);
            if (priorityQueue.size() > k)
                priorityQueue.poll();
        }
        List<String> wordsList = new ArrayList<String>();
        while (!priorityQueue.isEmpty())
            wordsList.add(priorityQueue.poll().word);
        Collections.reverse(wordsList);
        return wordsList;
    }
}

class WordCount implements Comparable<WordCount> {
    public String word;
    public int count;

    public WordCount() {
        
    }

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public int compareTo(WordCount wordCount2) {
        if (this.count != wordCount2.count)
            return this.count - wordCount2.count;
        else
            return wordCount2.word.compareTo(this.word);
    }
}
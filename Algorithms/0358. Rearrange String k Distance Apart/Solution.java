class Solution {
    public String rearrangeString(String s, int k) {
        if (k <= 1 || s.length() == 1)
            return s;
        Map<Character, Integer> letterCountMap = new HashMap<Character, Integer>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int count = letterCountMap.getOrDefault(c, 0) + 1;
            letterCountMap.put(c, count);
        }
        PriorityQueue<LetterCount> priorityQueue = new PriorityQueue<LetterCount>();
        Set<Character> keySet = letterCountMap.keySet();
        for (char letter : keySet) {
            int count = letterCountMap.get(letter);
            priorityQueue.offer(new LetterCount(letter, count));
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i += k) {
            int curLetters = Math.min(k, length - i);
            List<LetterCount> tempList = new ArrayList<LetterCount>();
            for (int j = 0; j < curLetters; j++) {
                if (priorityQueue.isEmpty())
                    return "";
                LetterCount letterCount = priorityQueue.poll();
                sb.append(letterCount.letter);
                letterCount.count--;
                if (letterCount.count > 0)
                    tempList.add(letterCount);
            }
            for (LetterCount letterCount : tempList)
                priorityQueue.offer(letterCount);
        }
        return sb.toString();
    }
}

class LetterCount implements Comparable<LetterCount> {
    char letter;
    int count;

    public LetterCount(char letter, int count) {
        this.letter = letter;
        this.count = count;
    }

    public int compareTo(LetterCount letterCount2) {
        if (this.count != letterCount2.count)
            return letterCount2.count - this.count;
        else
            return this.letter - letterCount2.letter;
    }
}
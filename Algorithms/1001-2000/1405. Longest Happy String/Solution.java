class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<LetterCount> priorityQueue = new PriorityQueue<LetterCount>();
        if (a > 0)
            priorityQueue.offer(new LetterCount('a', a));
        if (b > 0)
            priorityQueue.offer(new LetterCount('b', b));
        if (c > 0)
            priorityQueue.offer(new LetterCount('c', c));
        StringBuffer sb = new StringBuffer();
        char prevLetter = 'z';
        int prevCount = 0;
        while (!priorityQueue.isEmpty()) {
            LetterCount letterCount = priorityQueue.poll();
            char letter = letterCount.letter;
            int count = letterCount.count;
            if (letter == prevLetter) {
                if (prevCount < 2) {
                    int curCount = Math.min(count, 2 - prevCount);
                    for (int i = 0; i < curCount; i++)
                        sb.append(letter);
                    prevCount += curCount;
                    letterCount.count -= curCount;
                    if (letterCount.count > 0)
                        priorityQueue.offer(letterCount);
                } else {
                    if (priorityQueue.isEmpty())
                        break;
                    LetterCount letterCount2 = priorityQueue.poll();
                    sb.append(letterCount2.letter);
                    letterCount2.count--;
                    if (letterCount2.count > 0)
                        priorityQueue.offer(letterCount2);
                    priorityQueue.offer(letterCount);
                    prevLetter = letterCount2.letter;
                    prevCount = 1;
                }
            } else {
                int curCount = Math.min(count, 2);
                for (int i = 0; i < curCount; i++)
                    sb.append(letter);
                letterCount.count -= curCount;
                if (letterCount.count > 0)
                    priorityQueue.offer(letterCount);
                prevLetter = letter;
                prevCount = curCount;
            }
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
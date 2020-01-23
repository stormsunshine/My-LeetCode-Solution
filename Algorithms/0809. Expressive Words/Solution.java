class Solution {
    public int expressiveWords(String S, String[] words) {
        LetterCount[] letterCounts = getLetterCounts(S);
        int length = letterCounts.length;
        int expressiveWordsCount = 0;
        for (String word : words) {
            LetterCount[] curLetterCounts = getLetterCounts(word);
            if (curLetterCounts.length == length) {
                boolean flag = true;
                for (int i = 0; i < length; i++) {
                    LetterCount letterCount1 = letterCounts[i];
                    LetterCount letterCount2 = curLetterCounts[i];
                    if (letterCount1.letter == letterCount2.letter) {
                        if (letterCount1.count < letterCount2.count || letterCount1.count > letterCount2.count && letterCount1.count < 3) {
                            flag = false;
                            break;
                        }
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    expressiveWordsCount++;
            }
        }
        return expressiveWordsCount;
    }

    public LetterCount[] getLetterCounts(String str) {
        List<LetterCount> list = new ArrayList<LetterCount>();
        char prevC = 0;
        int curCount = 0;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (prevC == c)
                curCount++;
            else {
                if (prevC != 0) {
                    LetterCount letterCount = new LetterCount(prevC, curCount);
                    list.add(letterCount);
                }
                curCount = 1;
            }
            prevC = c;
        }
        if (curCount > 0) {
            LetterCount letterCount = new LetterCount(prevC, curCount);
            list.add(letterCount);
        }
        int size = list.size();
        LetterCount[] letterCounts = new LetterCount[size];
        for (int i = 0; i < size; i++)
            letterCounts[i] = list.get(i);
        return letterCounts;
    }
}

class LetterCount {
    char letter;
    int count;

    public LetterCount(char letter, int count) {
        this.letter = letter;
        this.count = count;
    }

    public String toString() {
        return "[" + letter + ", " + count + "]";
    }
}
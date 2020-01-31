class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> justification = new ArrayList<String>();
        StringBuffer line = new StringBuffer();
        int lineWords = 0;
        int wordsCount = words.length;
        for (int i = 0; i < wordsCount; i++) {
            String word = words[i];
            if (line.length() + word.length() <= maxWidth) {
                line.append(word + " ");
                lineWords++;
            } else {
                String justifyLine = justifyLine(line, lineWords, maxWidth);
                justification.add(justifyLine);
                line.setLength(0);
                line.append(word + " ");
                lineWords = 1;
            }
        }
        if (line.length() > 0) {
            String justifyLine = justifyLastLine(line, maxWidth);
            justification.add(justifyLine);
        }
        return justification;
    }

    public String justifyLine(StringBuffer line, int lineWords, int maxWidth) {
        int length = line.length();
        if (line.charAt(length - 1) == ' ') {
            line.deleteCharAt(length - 1);
            length--;
        }
        if (lineWords == 1) {
            while (line.length() < maxWidth)
                line.append(" ");
        } else {
            int splits = lineWords - 1;
            int remain = maxWidth - length;
            int index = length - 1;
            while (remain > 0) {
                int spacesCount = remain / splits;
                while (index > 0 && (line.charAt(index) != ' ' || line.charAt(index) == ' ' && line.charAt(index - 1) == ' '))
                    index--;
                for (int i = 0; i < spacesCount; i++)
                    line.insert(index, ' ');
                splits--;
                remain -= spacesCount;
                index--;
            }
        }
        return line.toString();
    }

    public String justifyLastLine(StringBuffer line, int maxWidth) {
        int length = line.length();
        if (line.charAt(length - 1) == ' ') {
            line.deleteCharAt(length - 1);
            length--;
        }
        while (line.length() < maxWidth)
            line.append(" ");
        return line.toString();
    }
}
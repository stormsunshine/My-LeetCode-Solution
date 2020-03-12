class Solution {
    public int compress(char[] chars) {
        if (chars == null)
            return 0;
        int length = chars.length;
        if (length <= 1)
            return length;
        int index = 0;
        char prevChar = chars[0];
        int count = 1;
        for (int i = 1; i < length; i++) {
            char c = chars[i];
            if (c == prevChar)
                count++;
            else {
                chars[index] = prevChar;
                index++;
                if (count > 1) {
                    String countStr = String.valueOf(count);
                    int countLength = countStr.length();
                    for (int j = 0; j < countLength; j++) {
                        chars[index] = countStr.charAt(j);
                        index++;
                    }
                    count = 1;
                }
                prevChar = c;
            }
        }
        if (count > 0) {
            chars[index] = prevChar;
            index++;
            if (count > 1) {
                String countStr = String.valueOf(count);
                int countLength = countStr.length();
                for (int j = 0; j < countLength; j++) {
                    chars[index] = countStr.charAt(j);
                    index++;
                }
            }
        }
        return index;
    }
}
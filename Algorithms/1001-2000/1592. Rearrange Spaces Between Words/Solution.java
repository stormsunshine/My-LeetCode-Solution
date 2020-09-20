class Solution {
    public String reorderSpaces(String text) {
        List<String> wordsList = new ArrayList<String>();
        int spaces = 0;
        StringBuffer sb = new StringBuffer();
        int length = text.length();
        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                spaces++;
                if (sb.length() > 0) {
                    wordsList.add(sb.toString());
                    sb.setLength(0);
                }
            } else
                sb.append(c);
        }
        if (sb.length() > 0)
            wordsList.add(sb.toString());
        StringBuffer reorder = new StringBuffer();
        int size = wordsList.size();
        if (size == 1) {
            reorder.append(wordsList.get(0));
            for (int i = 0; i < spaces; i++)
                reorder.append(' ');
            return reorder.toString();
        }
        int spacesEach = spaces / (size - 1);
        int remain = spaces % (size - 1);
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                for (int j = 0; j < spacesEach; j++)
                    reorder.append(' ');
            }
            reorder.append(wordsList.get(i));
        }
        for (int i = 0; i < remain; i++)
            reorder.append(' ');
        return reorder.toString();
    }
}
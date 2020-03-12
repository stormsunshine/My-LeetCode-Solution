class Solution {
    public List<String> printVertically(String s) {
        String[] array = s.split(" ");
        int wordsCount = array.length;
        int[] lengths = new int[wordsCount];
        int maxLength = 0;
        for (int i = 0; i < wordsCount; i++) {
            int length = array[i].length();
            lengths[i] = length;
            maxLength = Math.max(maxLength, length);
        }
        List<StringBuffer> stringBufferList = new ArrayList<StringBuffer>();
        for (int i = 0; i < maxLength; i++)
            stringBufferList.add(new StringBuffer());
        for (int i = 0; i < wordsCount; i++) {
            String word = array[i];
            int length = word.length();
            for (int j = 0; j < length; j++)
                stringBufferList.get(j).append(word.charAt(j));
            for (int j = length; j < maxLength; j++)
                stringBufferList.get(j).append(' ');
        }
        for (int i = 0; i < maxLength; i++) {
            StringBuffer sb = stringBufferList.get(i);
            while (sb.charAt(sb.length() - 1) == ' ')
                sb.deleteCharAt(sb.length() - 1);
            stringBufferList.set(i, sb);
        }
        List<String> verticalList = new ArrayList<String>();
        for (int i = 0; i < maxLength; i++)
            verticalList.add(stringBufferList.get(i).toString());
        return verticalList;
    }
}
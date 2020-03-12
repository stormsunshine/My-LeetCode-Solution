class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> occurrencesList = new ArrayList<String>();
        String[] textArray = text.split(" ");
        int length = textArray.length;
        for (int i = 2; i < length; i++) {
            String word1 = textArray[i - 2], word2 = textArray[i - 1];
            if (word1.equals(first) && word2.equals(second))
                occurrencesList.add(textArray[i]);
        }
        int size = occurrencesList.size();
        String[] occurrencesArray = new String[size];
        for (int i = 0; i < size; i++)
            occurrencesArray[i] = occurrencesList.get(i);
        return occurrencesArray;
    }
}
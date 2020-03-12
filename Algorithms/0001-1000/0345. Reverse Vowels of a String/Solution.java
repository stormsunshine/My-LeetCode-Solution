class Solution {
    public String reverseVowels(String s) {
        char[] array = s.toCharArray();
        int length = array.length;
        List<Integer> vowelIndices = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            if (isVowel(array[i]))
                vowelIndices.add(i);
        }
        int low = 0, high = vowelIndices.size() - 1;
        while (low < high) {
            int indexLow = vowelIndices.get(low), indexHigh = vowelIndices.get(high);
            char temp = array[indexLow];
            array[indexLow] = array[indexHigh];
            array[indexHigh] = temp;
            low++;
            high--;
        }
        return new String(array);
    }

    public boolean isVowel(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseArray = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<String>();
        for (String word : words) {
            StringBuffer sb = new StringBuffer();
            char[] array = word.toCharArray();
            for (char c : array)
                sb.append(morseArray[c - 'a']);
            set.add(sb.toString());
        }
        return set.size();
    }
}
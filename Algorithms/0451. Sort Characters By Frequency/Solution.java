class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] array = s.toCharArray();
        for (char c : array) {
            int count = map.getOrDefault(c, 0);
            count++;
            map.put(c, count);
        }
        List<CharacterCount> list = new ArrayList<CharacterCount>();
        Set<Character> keySet = map.keySet();
        for (char c : keySet) {
            int count = map.getOrDefault(c, 0);
            list.add(new CharacterCount(c, count));
        }
        Collections.sort(list);
        StringBuffer sortedSB = new StringBuffer();
        for (CharacterCount characterCount : list) {
            char character = characterCount.character;
            int count = characterCount.count;
            for (int i = 0; i < count; i++)
                sortedSB.append(character);
        }
        return sortedSB.toString();
    }
}

class CharacterCount implements Comparable<CharacterCount> {
    char character;
    int count;

    public CharacterCount(char character, int count) {
        this.character = character;
        this.count = count;
    }

    public int compareTo(CharacterCount characterCount2) {
        return characterCount2.count - this.count;
    }
}
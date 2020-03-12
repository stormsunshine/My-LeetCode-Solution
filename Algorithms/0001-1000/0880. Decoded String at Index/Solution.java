class Solution {
    public String decodeAtIndex(String S, int K) {
        TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();
        long count = 0;
        int length = S.length();
        int index = 0;
        while (index < length && count < K) {
            char c = S.charAt(index);
            if (Character.isLetter(c))
                count++;
            else
                count *= c - '0';
            map.put(count, index);
            index++;
        }
        long position = K;
        while (!map.containsKey(position) || Character.isDigit(S.charAt(map.get(position)))) {
            long key = map.floorKey(position - 1);
            position %= key;
            if (position == 0)
                position = key;
        }
        int strIndex = map.get(position);
        char letter = S.charAt(strIndex);
        return String.valueOf(letter);
    }
}
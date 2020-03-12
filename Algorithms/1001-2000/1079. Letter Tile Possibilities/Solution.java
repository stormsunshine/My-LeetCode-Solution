class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> allTiles = new HashSet<String>();
        int length = tiles.length();
        int maxCombinations = (int) Math.pow(2, length);
        for (int i = 1; i < maxCombinations; i++) {
            Set<String> permutations = permutations(tiles, i);
            allTiles.addAll(permutations);
        }
        return allTiles.size();
    }

    public Set<String> permutations(String tiles, int index) {
        int length = tiles.length();
        int[] binary = new int[length];
        int remain = index;
        for (int i = length - 1; i >= 0; i--) {
            int remainder = remain % 2;
            binary[i] = remainder;
            remain /= 2;
            if (remain == 0)
                break;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if (binary[i] == 1)
                sb.append(tiles.charAt(i));
        }
        char[] array = sb.toString().toCharArray();
        char[] sorted = sb.toString().toCharArray();
        Arrays.sort(array);
        Arrays.sort(sorted);
        Set<String> set = new HashSet<String>();
        set.add(new String(array));
        nextPermutation(array);
        while (!Arrays.equals(array, sorted)) {
            String str = new String(array);
            set.add(str);
            nextPermutation(array);
        }
        return set;
    }

    public void nextPermutation(char[] array) {
        int length = array.length;
        int index = -1;
        char curC = 0;
        for (int i = length - 1; i > 0; i--) {
            int difference = array[i] - array[i - 1];
            if (difference > 0) {
                index = i - 1;
                curC = array[index];
                break;
            }
        }
        if (index < 0) {
            Arrays.sort(array);
            return;
        }
        int nextIndex = -1;
        char nextC = 'a';
        for (int i = index + 1; i < length; i++) {
            if (array[i] > curC && array[i] < nextC) {
                nextIndex = i;
                nextC = array[i];
            }
        }
        array[index] = nextC;
        array[nextIndex] = curC;
        Arrays.sort(array, index + 1, length);
    }
}
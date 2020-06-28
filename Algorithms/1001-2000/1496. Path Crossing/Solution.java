class Solution {
    public boolean isPathCrossing(String path) {
        char[] directionChars = {'N', 'S', 'E', 'W'};
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < 4; i++)
            map.put(directionChars[i], i);
        Set<String> set = new HashSet<String>();
        int x = 0, y = 0;
        set.add(Arrays.toString(new int[]{0, 0}));
        int length = path.length();
        for (int i = 0; i < length; i++) {
            char c = path.charAt(i);
            int index = map.get(c);
            int[] direction = directions[index];
            x += direction[0];
            y += direction[1];
            int[] array = {x, y};
            if (!set.add(Arrays.toString(array)))
                return true;
        }
        return false;
    }
}
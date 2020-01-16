class Solution {
    public boolean validWordSquare(List<String> words) {
        int rows = words.size();
        for (int i = 0; i < rows; i++) {
            String word = words.get(i);
            int columns = word.length();
            if (columns > rows)
                return false;
            for (int j = 0; j < columns; j++) {
                char c1 = word.charAt(j);
                if (words.get(j).length() <= i)
                    return false;
                char c2 = words.get(j).charAt(i);
                if (c1 != c2)
                    return false;
            }
        }
        return true;
    }
}
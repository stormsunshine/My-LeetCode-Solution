class Solution {
    public int countBinarySubstrings(String s) {
        int count = 0;
        int length = s.length();
        List<Integer> indices = new ArrayList<Integer>();
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1))
                indices.add(i);
        }
        for (int index : indices) {
            int indexLeft = index, indexRight = index + 1;
            char charLeft = s.charAt(indexLeft), charRight = s.charAt(indexRight);
            while (indexLeft >= 0 && indexRight < length) {
                if (s.charAt(indexLeft) != charLeft || s.charAt(indexRight) != charRight)
                    break;
                count++;
                indexLeft--;
                indexRight++;
            }
        }
        return count;
    }
}